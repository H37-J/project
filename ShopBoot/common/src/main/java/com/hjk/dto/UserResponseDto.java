package com.hjk.dto;

import com.hjk.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private long id;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private String accountId;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String coupon;

    private int point;

    private String profile;

    private String address_main;

    private String address_sub;

    private String request;

    private String authorities;

    private String deleted;

    private LocalDateTime deletedDate;

    private LocalDateTime deletedDateWill;

    // id가 없으면 업데이트가 아니고 추가가 되어버림
    public User toEntity() {
        return User.builder().id(this.id).createAt(this.createAt).accountId(this.accountId).password(this.password)
                .name(this.name).profile(this.profile).phone(this.phone).email(this.email).coupon(this.coupon)
                .point(this.point).address_main(this.address_main).address_sub(this.address_sub).request(this.request)
                .authorities(this.authorities).deleted(this.deleted).deletedDate(this.deletedDate).deletedDateWill(this.deletedDateWill).build();
    }

    // 주문시 주문정보 바꾸면 업데이트
    public UserResponseDto updateOrderInfo(User userRequest) {
        this.request = userRequest.getRequest();
        this.email = userRequest.getEmail();
        this.phone = userRequest.getPhone();
        this.address_main = userRequest.getAddress_main();
        this.address_sub = userRequest.getAddress_sub();
        return this;
    }

    // 포인트 사용시 업데이트
    public UserResponseDto updatePoint(UserRequestDto.PointRequestDto userRequest) {
        this.point = this.point - userRequest.getUsedPoint();
        this.point = this.point + userRequest.getPlusPoint() / 100;
        return this;
    }

    public UserResponseDto updateId(){
        this.accountId="kafka";
        return this;
    }

    // 휴먼계정의 날짜 NULL체크
    public boolean isDeletedDate() {
        return this.deletedDate != null;
    }

    // 휴먼계정 체크
    public boolean isHuman() {
        return this.deleted.equals("Y");
    }

    @Override
    public String toString() {
        return id + "," + accountId.toString();
    }

  
}
