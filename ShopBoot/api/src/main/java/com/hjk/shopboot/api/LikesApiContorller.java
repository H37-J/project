package com.hjk.shopboot.api;


import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.hjk.model.Likes;
import com.hjk.shopboot.service.LikesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LikesApiContorller {
    
    private final LikesService likesService;

    @ApiOperation(value="사용자 모든 라이크 조회 API")
    @RequestMapping(value="getLikesAll", method=RequestMethod.GET)
    public ResponseEntity<List<Likes>> getLieksAll() {
        return ResponseEntity.ok(likesService.getAllLikes());
    }

    @ApiOperation(value="나의 모든 라이크 조회 API")
    @RequestMapping(value="getMyLikesAll", method=RequestMethod.GET)
    public ResponseEntity<List<Likes>> getMyLikesAll() {
        return ResponseEntity.ok(likesService.getMyLikesAll());
    }

    @ApiOperation(value="사용자 좋아요 기록 저장")
    @RequestMapping(value="save", method=RequestMethod.POST)
    public void save(@RequestBody Likes likes) {
        likesService.likesSave(likes);
    }

    @ApiOperation(value="사용자 좋아요 기록 취소")
    @RequestMapping(value="cancel", method=RequestMethod.POST)
    public void cancel(@RequestBody Likes likes) {
        likesService.likeCancel(likes);
    }


    
    
}
