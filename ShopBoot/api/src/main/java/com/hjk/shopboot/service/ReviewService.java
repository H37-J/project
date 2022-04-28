package com.hjk.shopboot.service;
import java.util.List;

import com.hjk.model.Product;
import com.hjk.model.Review;
import com.hjk.shopboot.respository.LikesRepository;
import com.hjk.shopboot.respository.ReviewRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductService productService;
    private final LikesRepository likesRepository;

    //특정 상품 리뷰 조회
    public List<Review> getReview(long id){
        Product product=productService.getId(id);
        return reviewRepository.findAllByProduct(product);
    }

    //리뷰 저장
    public void reviewSave(Review review){
        reviewRepository.save(review);
    }

    //리뷰 수정
    public void reviewUpdate(long id,String contents){
        Review review=reviewRepository.findById(id);
        review.contentsUpdate(contents);
        reviewRepository.save(review);
    }

    //리뷰 삭제
    public void reviewDelete(long id){
        likesRepository.deleteByReview(id);
        reviewRepository.deleteById(id);
    }

    //좋아요 플러스 업데이트
    public List<Review> likePlus(long id){
        Review review=reviewRepository.findById(id);
        review.addLikes();
        reviewRepository.save(review);
        Product product=productService.getId(review.getProduct().getId());
        return reviewRepository.findAllByProduct(product);
    }

    //좋아요 마이너스 업데이트
    public List<Review> likeMinus(long id){
        Review review=reviewRepository.findById(id);
        review.minusLikes();
        reviewRepository.save(review);
        Product product=productService.getId(review.getProduct().getId());
        return reviewRepository.findAllByProduct(product);
    }
}
