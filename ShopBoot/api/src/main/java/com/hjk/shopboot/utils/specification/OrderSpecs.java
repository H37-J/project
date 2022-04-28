package com.hjk.shopboot.utils.specification;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.hjk.model.Orders;
import com.hjk.enums.OrderStatus;
import com.hjk.enums.Search;

public class OrderSpecs {

    //내 완료주문
    public static Specification<Orders> hasUser(long id){
        return new Specification<Orders>(){
            @Override
            public Predicate toPredicate(@NotNull Root<Orders> root,@NotNull CriteriaQuery<?> criteriaQuery,@NotNull CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.and(criteriaBuilder.equal(root.get("user"), id),criteriaBuilder.equal(root.get("orderStatus"),OrderStatus.COMPLETE));
            }
        };
    }

    //내 주문 검색시(미개발)
    public static Specification<Orders> hasUserTitle(long id,String keyword,String search){
        return new Specification<Orders>(){
            @Override
            public Predicate toPredicate(@NotNull Root<Orders> root, @NotNull CriteriaQuery<?> criteriaQuery, @NotNull CriteriaBuilder criteriaBuilder){
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("title"),"%"+keyword+"%"),criteriaBuilder.equal(root.get("user"), id));
            }
        };
    };

    //진행중인 주문
    public static Specification<Orders> hasUserOn(long id){
        return new Specification<Orders>(){
            @Override
            public Predicate toPredicate(@NotNull Root<Orders> root, @NotNull CriteriaQuery<?> criteriaQuery, @NotNull CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.and(criteriaBuilder.equal(root.get("user"),id),criteriaBuilder.equal(root.get("orderStatus"),OrderStatus.ON));
               
            }
        };
    };
    
    //관리자 주문 검색
    public static Specification<Orders> hasTitle(String keyword,Search search){
        return new Specification<Orders>(){
            @Override
            public Predicate toPredicate(@NotNull Root<Orders> root, @NotNull CriteriaQuery<?> criteriaQuery, @NotNull CriteriaBuilder criteriaBuilder){
                if(search.equals(Search.ALL) || search.equals(Search.TITLE)){
                    return criteriaBuilder.like(root.get("title"),"%"+keyword+"%");
                }
                return null;
            }
        };
    };
}
