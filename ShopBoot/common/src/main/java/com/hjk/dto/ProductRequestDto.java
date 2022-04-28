package com.hjk.dto;

import com.hjk.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ProductRequestDto {

    @Getter
    @Setter
    @ToString
    public static class UploadRequestDto {

        private long id;

        private LocalDateTime createAt;

        @NotBlank(message = "상품명을 입력 해주세요")
        private String title;

        @NotBlank(message = "상품설명을 입력 해주세요")
        private String content;

        @NotBlank(message = "메인 카테고리를 입력 해주세요")
        private String category_main;

        @NotBlank(message = "하위 카테고리를 입력 해주세요")
        private String category_sub;

        private long price;

        private long stock;

        @NotBlank(message = "사이즈를 입력 해주세요")
        private String size;

        @NotBlank(message = "메인 이미지1를 등록 해주세요")
        private String main_image1;

        @NotBlank(message = "메인 이미지2를 등록 해주세요")
        private String main_image2;

        @NotBlank(message = "메인 이미지3를 등록 해주세요")
        private String main_image3;

        @NotBlank(message = "설명 1를 입력 해주세요")
        private String description1;

        @NotBlank(message = "설명 2를 입력 해주세요")
        private String description2;

        @NotBlank(message = "설명 3를 입력 해주세요")
        private String description3;

        @NotBlank(message = "상세 이미지1를 등록 해주세요")
        private String des_image1;

        @NotBlank(message = "상세 이미지2를 등록 해주세요")
        private String des_image2;

        @NotBlank(message = "상세 이미지3를 등록 해주세요")
        private String des_image3;

        @NotBlank(message = "상품 분류를 선택 해주세요")
        public String status;

        private LocalDateTime comingdate;

        public Product toEntity() {
            return Product.builder().id(this.id).createAt(this.createAt).title(this.title).content(this.content).category_main(this.category_main)
                    .category_sub(this.category_sub).price(this.price).stock(this.stock).main_image1(this.main_image1).status(this.status)
                    .main_image2(this.main_image2).main_image3(this.main_image3).description1(this.description1)
                    .description2(this.description2).description3(this.description3).des_image1(this.des_image1).size(this.size)
                    .des_image2(this.des_image2).des_image3(this.des_image3).status(this.status).comingdate(this.comingdate).build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class ModifyRequestDto {

        private long id;

        private LocalDateTime createAt;

        @NotBlank(message = "상품명을 입력 해주세요")
        private String title;

        @NotBlank(message = "상품설명을 입력 해주세요")
        private String content;

        @NotBlank(message = "메인 카테고리를 입력 해주세요")
        private String category_main;

        @NotBlank(message = "하위 카테고리를 입력 해주세요")
        private String category_sub;

        private long price;

        private long stock;

        @NotBlank(message = "사이즈를 입력 해주세요")
        private String size;

        private String main_image1;

        private String main_image2;

        private String main_image3;

        @NotBlank(message = "설명 1를 입력 해주세요")
        private String description1;

        @NotBlank(message = "설명 2를 입력 해주세요")
        private String description2;

        @NotBlank(message = "설명 3를 입력 해주세요")
        private String description3;

        private String des_image1;

        private String des_image2;

        private String des_image3;

        @NotBlank(message = "상품 분류를 선택 해주세요")
        public String status;

        private LocalDateTime comingdate;


        public Product toEntity() {
            return Product.builder().id(this.id).createAt(this.createAt).title(this.title).content(this.content).category_main(this.category_main)
                    .category_sub(this.category_sub).price(this.price).stock(this.stock).main_image1(this.main_image1).status(this.status)
                    .main_image2(this.main_image2).main_image3(this.main_image3).description1(this.description1)
                    .description2(this.description2).description3(this.description3).des_image1(this.des_image1).size(this.size)
                    .des_image2(this.des_image2).des_image3(this.des_image3).status(this.status).comingdate(this.comingdate).build();
        }
    }
}
