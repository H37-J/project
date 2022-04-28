package com.hjk.shopboot.respository;
import java.util.List;

import com.hjk.model.Product;
import com.hjk.model.Review;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByProduct(Product product);
    Review findById(long id);

    //상품 삭제시 장바구니 삭제
    @Transactional
    @Modifying
    @Query(value="delete from review R where R.product_id=:product ",nativeQuery = true)
    void deleteByProduct(@Param("product")long product);
}
