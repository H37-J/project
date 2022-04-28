// package com.hjk.shopboot.api;

// import java.util.List;

// import com.hjk.shopboot.model.Card;
// import com.hjk.shopboot.service.CardService;
// import io.swagger.annotations.ApiOperation;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/api/card")
// @RequiredArgsConstructor
// @CrossOrigin("*")
// public class CardApiController {

//     private final CardService cardService;

//     @ApiOperation(value="내 카드정보 조회")
//     @RequestMapping(value="/getMyCard",)
//     public ResponseEntity<List<Card>> getCardAll(){
//         return ResponseEntity.ok(cardService.getMyCard());
//     }

//     @ApiOperation(value="카드정보 업데이트")
//     @RequestMapping(value="/cardUpdate")
//     public void cardUpdate(@RequestBody Card card){
//         cardService.cardSave(card);
//     }
// }
