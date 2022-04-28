package com.hjk.shopboot.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import com.hjk.dto.UserResponseDto;
import com.hjk.model.User;


@Getter
@Setter
public class SecurityUser extends org.springframework.security.core.userdetails.User  {
    private static final String ROLE_PREFIX="ROLE_";
    private static final long serialVersionUID=1L;

    public SecurityUser(UserResponseDto user){
        super(user.getAccountId(),user.getPassword(),makeGrantedAuthority(user.getAuthorities()));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(String authorities){
        List<GrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority(authorities));

        return list;
    }
}
