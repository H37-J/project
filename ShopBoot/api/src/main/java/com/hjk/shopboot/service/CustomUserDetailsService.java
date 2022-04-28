package com.hjk.shopboot.service;

import com.hjk.kafka.channel.RegisterSuccessOutputChannel;
import com.hjk.kafka.publisher.MessagePublisher;
import com.hjk.shopboot.common.SecurityUser;
import com.hjk.dto.UserResponseDto;

import com.hjk.model.User;
import com.hjk.shopboot.exception.CustomException;
import com.hjk.shopboot.exception.UserException;
import com.hjk.shopboot.respository.UserRepository;
import com.hjk.shopboot.utils.session.SessionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final CartService cartService;


    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new CustomException(UserException.NOT_FOUND_USER));
        UserResponseDto userResponse = user.toResponseDto();
        if (userResponse.isHuman())
            throw new CustomException(UserException.IS_HUMAN);
        SessionUtils.setUser(userResponse);
        cartService.getMyCartAll();


        return new SecurityUser(userResponse);
    }

}
