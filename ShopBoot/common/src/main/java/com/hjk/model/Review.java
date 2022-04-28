package com.hjk.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review extends Base {

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId", unique = false, nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", unique = false, nullable = false)
    private Product product;

    @Column
    private String contents;

    @Column
    private int likes;

    @Column
    private int rates;

    public void addLikes() {
        this.likes = this.likes + 1;
    }

    public void minusLikes() {
        this.likes = this.likes - 1;
    }

    public void contentsUpdate(String contents) {
        this.contents = contents;
    }
}
