package com.hjk.shopboot.respository;
import java.util.List;

import com.hjk.model.Likes;
import com.hjk.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {
    List<Likes> findAllByUser(User user);
    Likes findById(long id);

    //상품 삭제시 기록삭제
    @Transactional
    @Modifying
    @Query(value="delete from likes L where L.product_id=:product",nativeQuery = true)
    void deleteByProduct(@Param("product")long product);

    //좋아요 기록 삭제
    @Transactional
    @Modifying
    @Query(value="Delete from likes where review_id=:review",nativeQuery=true)
    void deleteByReview(@Param("review")long review);

    //사용자 좋아요 기록 취소
    @Transactional
    @Modifying
    @Query(value="Delete from likes where customer_id=:user and review_id=:review",nativeQuery=true)
    void deleteByUserReview(@Param("user")long user, @Param("review")long review);
}
