package com.hjk.shopboot.service;
import java.util.List;

import com.hjk.dto.UserResponseDto;
import com.hjk.model.Card;
import com.hjk.shopboot.respository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class CardService {

    private final HttpSession session;
    private final CardRepository paymentRepository;

    //내 카드정보 조회
    public List<Card> getMyCard(){
        UserResponseDto user=(UserResponseDto)session.getAttribute("User");
        session.setAttribute("card",paymentRepository.findAllByUser(user.toEntity()));
        return paymentRepository.findAllByUser(user.toEntity());
    }

    public void cardSave(Card c){
        UserResponseDto user=(UserResponseDto)session.getAttribute("User");
        Card card= Card.builder().user(user.toEntity()).cardOwner(c.getCardOwner())
                .cardNumber(c.getCardNumber()).mm(c.getMm())
                .yy(c.getYy()).secret(c.getSecret()).build();
        paymentRepository.save(card);
    }
}
