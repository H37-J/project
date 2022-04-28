package com.hjk.dto;

import com.hjk.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserRequestDto {

    @Getter
    @ToString
    @Builder
    public static class LoginRequestDto{
        @NotBlank(message="아이디를 입력해주세요.")
        private String accountId;
    
        @NotBlank(message="비밀번호를 입력해주세요")
        private String password;
    
        public User toEntity(){
            return User.builder()
            .accountId(this.accountId)
            .password(this.password)
            .build();
        }

        public static LoginRequestDto buildDto(String accountId, String password){
            return LoginRequestDto.builder().accountId(accountId).password(password).build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class SignRequestDto{
        @NotBlank(message="아이디를 입력해주세요")
        @Pattern(regexp = "^(?=.*[a-zA-Z0-9]).{6,12}$", message = "아이디는 영문/숫자 조합 6자리 ~ 12자리")
        private String accountId;

        @NotBlank(message="비밀번호를 입력해주세요")
        @Pattern(regexp = "^(?=.*[a-zA-Z0-9`~!@#$%^&*()\\-_+=\\\\]).{8,15}$", message = "비밀번호는 영문/숫자/특수문자 조합 8자리~15자리")
        private String password;

        @NotBlank(message = "이메일을 작성해주세요.")
        @Email(message = "이메일의 양식을 지켜주세요.")
        private String email;

        @NotBlank(message="닉네임을 입력해주세요")
        @Size(max = 10, message = "이름은 10자 내외로 작성해주세요.")
        private String name;

        private String authorities;

        private String deleted;

        public User toEntity(){
            return User.builder().accountId(this.accountId)
                                 .password(this.password)
                                 .name(this.name)
                                 .email(this.email)
                                 .authorities(this.authorities)
                                 .deleted(this.deleted)
                                 .build();
        }

        public static SignRequestDto buildDto(String accountId, String password,String name,String email){
            return SignRequestDto.builder().accountId(accountId).password(password).name(name).email(email).build();
        }
    }


    @Getter
    @ToString
    public static class PointRequestDto{
        int usedPoint;
        int plusPoint;
    }



    
}
