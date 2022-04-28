package com.hjk.shopboot.service;
import java.util.List;

import com.hjk.dto.UserResponseDto;
import com.hjk.model.Likes;
import com.hjk.shopboot.respository.LikesRepository;
import com.hjk.shopboot.utils.etc.ConvertUtils;
import com.hjk.shopboot.utils.session.SessionUtils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesService {
    
    private final LikesRepository likesRepository;

    //사용자 모든 좋아요 목록 리스트
    public List<Likes> getAllLikes(){
        return likesRepository.findAll();
    }

    public List<Likes> getMyLikesAll(){
        return likesRepository.findAllByUser(SessionUtils.getUserEntity());
    }

    //좋아요 기록 저장
    public void likesSave(Likes likes){
        likesRepository.save(likes);
    }

    //좋아요 기록 삭제
    public void likeCancel(Likes likes){
        likesRepository.deleteByUserReview(likes.getUser().getId(),likes.getReview().getId());
    }
}
