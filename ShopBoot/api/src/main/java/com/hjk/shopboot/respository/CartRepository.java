package com.hjk.shopboot.respository;

import java.util.List;

import com.hjk.model.Cart;
import com.hjk.model.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@EnableBinding(Cart.class)
public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findAllByUser(User user);
    List<Cart> findAllById(long id);

    //회원 탈퇴시 장바구니 삭제
    @Transactional
    @Modifying
    @Query(value="delete from cart C where C.customer_id=:user ",nativeQuery = true)
    void deleteByUser(@Param("user")long user);

    //상품 삭제시 장바구니 삭제
    @Transactional
    @Modifying
    @Query(value="delete from cart C where C.product_id=:product ",nativeQuery = true)
    void deleteByProduct(@Param("product")long product);

}
