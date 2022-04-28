package com.hjk.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hjk.jpa.domain.Product;
import com.hjk.jpa.domain.Sex;
import com.hjk.jpa.domain.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDao {

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime lastUpdateTime;

    private String name;

    private int age;

    private Sex sex;

    private LocalDate birthDate;

    private byte[] photo;

    private Collection<Long> productList;

    public static UserDao of(User user, Collection<Long> productIds){
        return UserDao.builder().id(user.getId()).age(user.getAge()).name(user.getName()).createTime(user.getCreateTime()).lastUpdateTime(user.getLastUpdateTime())
        .sex(user.getSex()).birthDate(user.getBirthDate()).photo(user.getPhoto())
        .productList(productIds).build();
    }

    public static List<UserDao> of(List<User> users){
        List<UserDao> userDaos = new ArrayList<>();
        List<Long> productIds;
        for(User user : users){
            productIds = new ArrayList<>();
            for(Product product : user.getProductList()){
                productIds.add(product.getId());
            }
            userDaos.add(UserDao.of(user, productIds));
        }
        return userDaos;
    }

}
