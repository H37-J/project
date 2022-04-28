package com.hjk.dto;

import com.hjk.model.Orders;
import com.hjk.model.Product;
import com.hjk.model.User;
import com.hjk.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class OrderRequestDto {

    private long id;

    private LocalDateTime createAt;

    private User user;

    private Product product;

    private int stock;

    private int price;

    private int total;

    private int point;

    private OrderStatus orderStatus;

    public Orders toEntity(){
        return Orders.builder().id(this.id).createAt(this.createAt).user(this.user).product(this.product)
        .stock(this.stock).price(this.price).total(this.total).point(this.point).orderStatus(this.orderStatus).build();
    }

    public void applyPoint(){
        this.total=this.total-this.point;
    }
}
