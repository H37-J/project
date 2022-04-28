package com.hjk.shopboot.utils.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import com.hjk.model.User;

public class UserSpecs {
    
    public static Specification<User> hasName(String keyword){
        return new Specification<User>(){
            @Override
            public Predicate toPredicate(@NotNull Root<User> root,@NotNull CriteriaQuery<?> criteriaQuery,
            @NotNull CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.like(root.get("name"),"%"+keyword+"%");
            }
        };
    }
}
