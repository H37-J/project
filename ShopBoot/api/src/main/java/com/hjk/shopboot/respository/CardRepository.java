package com.hjk.shopboot.respository;

import com.hjk.dto.UserResponseDto;
import com.hjk.model.Card;
import com.hjk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Long>,JpaSpecificationExecutor {
    List<Card> findAllByUser(User User);

}
