package com.hjk.model;

import com.hjk.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends Base {

    @ManyToOne(optional = false)
    @JoinColumn(name="customerId",nullable=false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name="productId", nullable=false)
    private Product product;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column private int stock;
    
    @Column private int price;

    @Column int point;

    @Column int total;

    @Builder
    public Orders(long id, LocalDateTime createAt, User user, Product product, OrderStatus orderStatus, int stock, int price, int point, int total){
        this.id=id;
        this.createAt=createAt;
        this.user=user;
        this.product=product;
        this.orderStatus=orderStatus;
        this.stock=stock;
        this.price=price;
        this.point=point;
        this.total=total;
    }



}