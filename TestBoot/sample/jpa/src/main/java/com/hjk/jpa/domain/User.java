package com.hjk.jpa.domain;


import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "user")
public class User extends Base {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE", nullable = false)
    private int age;

    @Column(name = "SEX", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_product",
    joinColumns = @JoinColumn(name ="USER_ID", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id"))
    private Collection<Product> productList;

    @AssertTrue(message = "성인이 아닙니다!")
    public boolean isAdult() {
        boolean result = true;
        if(age < 20 ) result = false;
        return result;
    }




    
}
