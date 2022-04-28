package com.hjk.shopboot.api;

import com.hjk.model.Review;
import com.hjk.shopboot.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReviewApiController {

    private final ReviewService reviewService;

    @ApiOperation(value = "특정상품 모든 리뷰 API")
    @RequestMapping(value = "getReplyAll",method=RequestMethod.GET)
    public ResponseEntity<List<Review>> getReplyAll(@RequestParam(value = "id") long id) {
        return ResponseEntity.ok(reviewService.getReview(id));
    }

    @ApiOperation(value = "리뷰 저장 API")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save(@RequestBody Review review) {
        reviewService.reviewSave(review);
    }

    @ApiOperation(value = "리뷰 수정 API")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(@RequestParam(value = "id") long id,@RequestParam(value="contents")String contents) {
        reviewService.reviewUpdate(id,contents);
    }

    @ApiOperation(value = "리뷰 삭제 API")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam(value = "id") long id) {
        reviewService.reviewDelete(id);
    }

    @ApiOperation(value="좋아요 플러스 업데이트API")
    @RequestMapping(value="likePlusUpdate", method = RequestMethod.POST)
    public void likePlusUpdate(@RequestParam(value="id") long id){
        reviewService.likePlus(id);
    }

    @ApiOperation(value="좋아요 마이너스 업데이트API")
    @RequestMapping(value="likeMinusUpdate", method = RequestMethod.POST)
    public void likeMinusUpdate(@RequestParam(value="id")long id){
        reviewService.likeMinus(id);
    }

}
