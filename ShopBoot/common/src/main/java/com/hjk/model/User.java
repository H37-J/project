package com.hjk.model;

import com.hjk.dto.UserResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
public class User extends Base implements Serializable {

    @Column
    private String accountId;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String coupon;

    @Column
    private int point;

    @Column
    private String profile;

    @Column
    private String request;

    @Column
    private String authorities;

    @Column
    private String address_main;

    @Column
    private String address_sub;

    @Column
    private String deleted;

    @Column
    private LocalDateTime deletedDate;

    @Column
    private LocalDateTime deletedDateWill;

    @Builder
    public User(long id, LocalDateTime createAt, String accountId, String password, String name, String email,
            String phone, String coupon, int point, String profile, String address_main, String address_sub,
            String request, String authorities, String deleted, LocalDateTime deletedDate,
            LocalDateTime deletedDateWill) {
        this.id = id;
        this.createAt = createAt;
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.coupon = coupon;
        this.point = point;
        this.profile = profile;
        this.address_main = address_main;
        this.address_sub = address_sub;
        this.authorities = authorities;
        this.request = request;
        this.deleted = deleted;
        this.deletedDate = deletedDate;
        this.deletedDateWill=deletedDateWill;
    }

    public UserResponseDto toResponseDto() {
        return UserResponseDto.builder().id(this.getId()).accountId(this.getAccountId()).createAt(this.getCreateAt())
                .updateAt(this.getUpdateAt()).email(this.getEmail()).phone(this.getPhone()).name(this.getName())
                .profile(this.getProfile()).address_main(this.getAddress_main()).address_sub(this.getAddress_sub())
                .request(this.getRequest()).authorities(this.getAuthorities()).point(this.getPoint())
                .coupon(this.getCoupon()).password(this.getPassword()).deleted(this.deleted)
                .deletedDate(this.deletedDate).deletedDateWill(this.deletedDateWill).build();
    }

}
