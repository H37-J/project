package com.hjk.shopboot.respository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.hjk.model.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor{
    Optional<User> findById(long id);
    Optional<User> findByAccountId(String accountId);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Page<User> findAll(Pageable pageable);
    Page<User> findAll(Specification spec,Pageable pageable);

    //배송정보 업데이트
    @Transactional
    @Modifying
    @Query(value="Update user U SET U.email=:email,U.point=:point where U.id=:id",nativeQuery = true)
    void updateOrderInfo(@Param("email")String email,@Param("point")String point,@Param("id")long id);

    //프로필 이미지 업로드
    @Transactional
    @Modifying
    @Query(value="Update user U SET U.profile=:profile where U.id=:id", nativeQuery=true)
    void updateProfile(@Param("profile")String profile,@Param("id")long id);

    //휴먼계정 복구
    @Transactional
    @Modifying
    @Query(value="Update user U set U.deleted='N', U.deleted_date=NULL where U.id=:id",nativeQuery=true)
    void userRecover(@Param("id")long id);

    //회원탈퇴 처리
    @Transactional
    @Modifying
    @Query(value="Update user U set U.deleted='Y', U.deleted_date=:deletedDate,U.deleted_date_will=:deletedDateWill where U.id=:id",nativeQuery=true)
    void deletedByAdmin(@Param("id")long id,@Param("deletedDate")String deletedDate,@Param("deletedDateWill")String deletedDateWill);
}
