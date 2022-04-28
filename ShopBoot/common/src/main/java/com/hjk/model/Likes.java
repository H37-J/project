package com.hjk.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Likes extends Base {
    
    @ManyToOne(optional = false)
    @JoinColumn(name="customerId", unique = false, nullable=false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name="reviewId", unique=false, nullable=false)
    private Review review;

    @ManyToOne(optional = false)
    @JoinColumn(name="productId", unique=false, nullable=false)
    private Product product;


}
