package com.hjk.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
public class Card extends Base {

    @ManyToOne(optional = false)
    @JoinColumn(name="customerId",unique=false,nullable=false)
    private User user;

    @Column private String cardOwner;

    @Column private long cardNumber;

    @Column private long mm;

    @Column private long yy;

    @Column private long secret;

    @Builder
    public Card(User user, String cardOwner, long cardNumber, long mm, long yy, long secret){
        this.user=user;
        this.cardOwner=cardOwner;
        this.cardNumber=cardNumber;
        this.mm=mm;
        this.yy=yy;
        this.secret=secret;
    }

}
