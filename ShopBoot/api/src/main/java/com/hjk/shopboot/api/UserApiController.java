package com.hjk.shopboot.api;

import com.hjk.kafka.channel.RegisterSuccessMailInputChannel;
import com.hjk.kafka.channel.RegisterSuccessOutputChannel;
import com.hjk.kafka.publisher.MessagePublisher;
import com.hjk.shopboot.exception.ValidException;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;
import com.hjk.dto.UserRequestDto;
import com.hjk.dto.UserResponseDto;
import com.hjk.model.User;
import com.hjk.shopboot.service.CustomUserDetailsService;
import com.hjk.shopboot.service.UserService;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
@EnableBinding({RegisterSuccessOutputChannel.class, MessagePublisher.class})
public class UserApiController {

    private final UserService userService;
    private final MessagePublisher messagePublisher;

    @ApiOperation(value="사이트 유저리스트 API")
    @RequestMapping(value="userList",method=RequestMethod.GET)
    private ResponseEntity<List<UserResponseDto>> userList(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @ApiOperation(value="회원가입 API")
    @RequestMapping(value="join",method=RequestMethod.POST)
    private ResponseEntity<?>  join(@Valid @RequestBody UserRequestDto.SignRequestDto signRequest,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidException(bindingResult);
        }
        messagePublisher.publishRegisterSuccessMessage(signRequest.toEntity());

        return ResponseEntity.ok(userService.join(signRequest));
    }

    @ApiOperation(value="로그인 API")
    @RequestMapping(value="login", method=RequestMethod.POST)
    private ResponseEntity<?> login(@Valid @RequestBody UserRequestDto.LoginRequestDto userRequest,BindingResult bindingResult){
         if(bindingResult.hasErrors()){
            throw new ValidException(bindingResult);
         }
        return ResponseEntity.ok(userService.login(userRequest));
    }

    @ApiOperation(value="사용자 정보 변경 업데이트 API")
    @RequestMapping(value="userUpdate",method=RequestMethod.POST)
    private void userUpdate(@RequestBody User userRequest){
        userService.update(userRequest);
    }


    @ApiOperation(value="사용자 프로필 사진 업데이트 API")
    @RequestMapping(value="profileUpdate",method=RequestMethod.POST)
    private void profileUpdate(@RequestBody User userRequest){
        userService.profileUpload(userRequest);
    }

    @ApiOperation(value="회원탈퇴 API")
    @RequestMapping(value="deleteByUser", method=RequestMethod.DELETE)
    public void delete(@RequestBody User userRequest){
        userService.deleteByUser(userRequest);
    }

    @ApiOperation(value="회원탈퇴 시키기(관리자) API")
    @RequestMapping(value="deleteByAdmin",method=RequestMethod.DELETE)
    public void deleteByAdmin(@RequestBody User userRequest){
        userService.deleteByAdmin(userRequest);
    }

    @ApiOperation(value="휴먼계정 복구 API")
    @RequestMapping(value="userRecover",method=RequestMethod.POST)
    public void userRecover(@RequestBody User userRequest){
        userService.userRecover(userRequest);
    }

    @ApiOperation(value="휴먼계정 기간 경과후 삭제 API")
    @RequestMapping(value="deleteByDate",method=RequestMethod.DELETE)
    public void deleteByDate(@RequestBody User userRequest){
        userService.deleteByDate(userRequest);
    }

    @ApiOperation(value="유저 주문정보 업데이트 API")
    @RequestMapping(value="updateOrderInfo",method=RequestMethod.POST)
    public void updateOderInfo(@RequestBody User userRequest){
        userService.updateOrderInfo(userRequest);
    }

    @ApiOperation(value="유저 포인트 업데이트 API")
    @RequestMapping(value="updateUserPoint",method=RequestMethod.POST)
    public void updatePoint(@RequestBody UserRequestDto.PointRequestDto userRequest){
        userService.updatePoint(userRequest);
    }

}
