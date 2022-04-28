package com.hjk.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Base {

    @Column public String title;

    @Column public String content;

    @Column public String category_main;

    @Column public String category_sub;

    @Column public long price;

    @Column public String size;

    @Column public long stock;

    @Column public String main_image1;

    @Column public String main_image2;

    @Column public String main_image3;

    @Column public String description1;

    @Column public String description2;

    @Column public String description3;

    @Column public String des_image1;

    @Column public String des_image2;

    @Column public String des_image3;

    @Column public String status;

    @Column public LocalDateTime comingdate;


    @Builder
    public Product(long id,LocalDateTime createAt,String title, String content,
    String category_main,String category_sub,long price,String size,long stock,
    String main_image1,String main_image2,String main_image3,String des_image1,String des_image2,String des_image3,
    String description1,String description2,String description3,
    String status,LocalDateTime comingdate){
        this.id=id;
        this.createAt=createAt;
        this.title=title;
        this.content=content;
        this.category_main=category_main;
        this.category_sub=category_sub;
        this.price=price;
        this.size=size;
        this.stock=stock;
        this.status=status;
        this.comingdate=comingdate;
        this.main_image1=main_image1;
        this.main_image2=main_image2;
        this.main_image3=main_image3;
        this.des_image1=des_image1;
        this.des_image2=des_image2;
        this.des_image3=des_image3;
        this.description1=description1;
        this.description2=description2;
        this.description3=description3;
    }
  
}
