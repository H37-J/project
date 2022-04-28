package com.hjk.shopboot.respository;

import java.util.List;


import javax.transaction.Transactional;
import com.hjk.model.Orders;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long>,JpaSpecificationExecutor {

    Page<Orders> findAllById(Pageable page,long id);
   
    @NotNull
    List<Orders> findAll(Specification spec);

    @NotNull
    Page<Orders> findAll(Specification spec, @NotNull Pageable page);

    //회원 탈퇴시 주문삭제
    @Transactional
    @Modifying
    @Query(value="delete from orders O where O.customer_id=:user",nativeQuery = true)
    void deleteByUser(@Param("user")long user);

    //상품 삭제시 주문삭제
    @Transactional
    @Modifying
    @Query(value="delete from orders O where O.product_id=:product",nativeQuery = true)
    void deleteByProduct(@Param("product")long product);

    //나의 주문 진행중 삭제
    @Transactional
    @Modifying
    @Query(value="delete from orders O where O.customer_id=:user and O.order_status='ON'",nativeQuery = true)
    void deleteOn(@Param("user")long user);

    //주문 완료시 상태 완료로 변경
    @Transactional
    @Modifying
    @Query(value="update orders O SET O.order_status='COMPLETE' where O.customer_id=:user and O.order_status='ON'",nativeQuery = true)
    void updateComplete(@Param("user")long user);

    //주문 취소로 변경
    @Transactional
    @Modifying
    @Query(value="update orders O SET O.order_status='CANCEL' where O.customer_id=:user and O.order_status='COMPLETE' and O.id=:id",nativeQuery = true)
    void updateCancel(@Param("user")long user,@Param("id")long id);

}