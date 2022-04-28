package com.hjk.shopboot.service;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.hjk.dto.PageDto;
import com.hjk.dto.UserRequestDto;
import com.hjk.dto.UserResponseDto;

import com.hjk.kafka.channel.RegisterSuccessMailInputChannel;
import com.hjk.model.User;
import com.hjk.shopboot.exception.CustomException;
import com.hjk.shopboot.exception.UserException;
import com.hjk.shopboot.respository.CartRepository;
import com.hjk.shopboot.respository.OrderRepository;
import com.hjk.shopboot.respository.UserRepository;
import com.hjk.enums.UserRole;
import com.hjk.shopboot.utils.session.SessionUtils;
import com.hjk.shopboot.utils.specification.UserSpecs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;

import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CartService cartService;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final RedisTemplate<String,Object> redisTemplate;


    //탈퇴 유저 명단
    public List<UserResponseDto> getAllUserDeleted(){
        List<User> userList=userRepository.findAll();
        List<UserResponseDto> userResponseDtoList=toResponseList(userList);
        userResponseDtoList=userResponseDtoList.stream().filter(e->e.getDeleted().equals("Y")).collect(Collectors.toList());
        return userResponseDtoList;
    }

    //탈퇴 유저 명단 Page
    public PageDto<UserResponseDto> getAllUserDeletedPage(Pageable page){
        Page<User> userList=userRepository.findAll(page);
        List<UserResponseDto> userResponseDtoList=toResponseList(userList);
        userResponseDtoList=userResponseDtoList.stream().filter(e->e.getDeleted().equals("Y")).collect(Collectors.toList());
        return PageDto.of(userList,userResponseDtoList);
    }

    //탈퇴 유저 명단 Page+Search
    public PageDto<UserResponseDto> getAllUserDeletedPageSearch(Pageable page,String keyword){
        Specification<User> spec=Specification.where(UserSpecs.hasName(keyword));
        Page<User> userList=userRepository.findAll(spec,page);
        List<UserResponseDto> userResponseDtoList=toResponseList(userList);
        userResponseDtoList=userResponseDtoList.stream().filter(e->e.getDeleted().equals("Y")).collect(Collectors.toList());
        return PageDto.of(userList,userResponseDtoList);
    }

    //사이트 유저 명단
    public List<UserResponseDto> getAllUser(){
        List<User> userList=userRepository.findAll();
        List<UserResponseDto> userResponseDtoList=toResponseList(userList);
        userResponseDtoList=userResponseDtoList.stream().filter(e->e.getDeleted().equals("N")).collect(Collectors.toList());
        return userResponseDtoList;
    }

    //사이트 유저 명단 Page
    public PageDto<UserResponseDto> getAllUserPage(Pageable page){
        Page<User> userList=userRepository.findAll(page);
        List<UserResponseDto> userResponseDtoList=toResponseList(userList);
        userResponseDtoList=userResponseDtoList.stream().filter(e->e.getDeleted().equals("N")).collect(Collectors.toList());
        return PageDto.of(userList,userResponseDtoList);
    }

    //사이트 유저 명단 Page+Search
    public PageDto<UserResponseDto> getAllUserPageSearch(Pageable page,String keyword){
        Specification<User> spec=Specification.where(UserSpecs.hasName(keyword));
        Page<User> userList=userRepository.findAll(spec,page);
        List<UserResponseDto> userResponseDtoList=toResponseList(userList);    
        userResponseDtoList=userResponseDtoList.stream().filter(e->e.getDeleted().equals("N")).collect(Collectors.toList());
        return PageDto.of(userList,userResponseDtoList);
    }

    //로그인
    public UserResponseDto login(UserRequestDto.LoginRequestDto userRequest){
        UserResponseDto userResponse=userRepository.findByAccountId(userRequest.getAccountId()).orElseThrow(()->new CustomException(UserException.NOT_FOUND_USER)).toResponseDto();
        isPasswordCheck(userRequest.toEntity(), userResponse);
        if(userResponse.isHuman()) throw new CustomException(UserException.IS_HUMAN);
        SessionUtils.setUser(userResponse);
        cartService.getMyCartAll();

        ZSetOperations<String,Object> zop=redisTemplate.opsForZSet();
        zop.add("user",userRequest,10);
        return userResponse;
    }

    //프로파일 사진 업로드
    public void profileUpload(User userRequest){
        userRepository.save(userRequest);
        SessionUtils.setUser(userRequest.toResponseDto());
    }
    
    //회원가입
    public UserRequestDto.SignRequestDto join(UserRequestDto.SignRequestDto signRequest){
        if(userRepository.findByAccountId(signRequest.getAccountId()).isPresent()) throw new CustomException(UserException.DUPLICATED_USER);
        if(userRepository.findByName(signRequest.getName()).isPresent()) throw new CustomException(UserException.DUPLICATED_NICKNAME);
        signRequest.setAuthorities(UserRole.USER.getKey());
        signRequest.setPassword(passwordEncoder.encode(signRequest.getPassword()));
        userRepository.save(signRequest.toEntity());
        return signRequest;
    }

    //회원정보 변경
    public void update(User user){
        if(userRepository.findByName(user.getName()).isPresent() && !SessionUtils.getUser().getName().equals(user.getName())) throw new CustomException(UserException.DUPLICATED_NICKNAME); //닉네임 중복체크
        if(userRepository.findByEmail(user.getEmail()).isPresent() && !SessionUtils.getUser().getEmail().equals(user.getEmail())) throw new CustomException(UserException.DUPLICATED_EMAIL); //이메일 중복체크
        if(!SessionUtils.getUser().getPassword().equals(user.getPassword())) user.setPassword(passwordEncoder.encode(user.getPassword())); //비밀번호 다를시에만 업데이트
        userRepository.save(user);
        SessionUtils.setUser(user.toResponseDto());
    }

    //휴먼계정 복구(유저)
    public void userRecover(User userRequest){
        userRepository.userRecover(userRequest.getId());
    }

    //회원탈퇴(유저)
    public void deleteByUser(User userRequest){
        LocalDateTime now=LocalDateTime.now();
        userRepository.deletedByAdmin(userRequest.getId(),now.toString(),now.plusMonths(1).toString());
        SessionUtils.setUserNull();
    }

    //탈퇴처리 날짜(관리자)
    public void deleteByAdmin(User userRequest){
        LocalDateTime now=LocalDateTime.now();
        userRepository.deletedByAdmin(userRequest.getId(),now.toString(),now.plusMonths(1).toString());
    }

    //기간 후 회원삭제
    public void deleteByDate(User userRequest){
        orderRepository.deleteByUser(userRequest.getId());
        cartRepository.deleteByUser(userRequest.getId());
        userRepository.deleteById(userRequest.getId());
    }


    //주문 기본정보 업데이트
    public void updateOrderInfo(User userRequest){
        UserResponseDto session=SessionUtils.getUser();
        session.updateOrderInfo(userRequest);
        userRepository.save(session.toEntity());
        SessionUtils.setUser(session);
    }

    //포인트 업데이트
    public void updatePoint(UserRequestDto.PointRequestDto userRequest){
        UserResponseDto session=SessionUtils.getUser();
        session.updatePoint(userRequest);
        userRepository.save(session.toEntity());
        SessionUtils.setUser(session);
    }

    public List<UserResponseDto> toResponseList(List<User> userList){
        List<UserResponseDto> userResponseDtoList=new ArrayList<>();
        for(User u: userList){
            UserResponseDto userResponse=u.toResponseDto();
            userResponseDtoList.add(userResponse);
        }
        return userResponseDtoList;
    }

    public List<UserResponseDto> toResponseList(Page<User> userList){
        List<UserResponseDto> userResponseDtoList=new ArrayList<>();
        for(User u: userList.getContent()){
            UserResponseDto userResponse=u.toResponseDto();
            userResponseDtoList.add(userResponse);
        }
        return userResponseDtoList;
    }


    //패스워드 채크
    public void isPasswordCheck(User userRequest,UserResponseDto session){
        if(!(passwordEncoder.matches(userRequest.getPassword(), session.getPassword())))
        throw new CustomException(UserException.PASS_CHECK);
    }

    @SuppressWarnings("unchecked")
    public RedisTemplate<String,Object> getRedisTemplate(ApplicationContext applicationContext){
        return applicationContext.getBean("redisCustomTemplate",RedisTemplate.class);
    }

    public ApplicationContext getApplicationContext(JobExecutionContext jobExecutionContext){
        ApplicationContext applicationContext= null;

        try{
            applicationContext=(ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContext");
        }catch(Exception e){
            log.error("Error",e.toString());
        }
        return applicationContext;
    }



}
