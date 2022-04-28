package com.hjk.jpa.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
@ToString(callSuper = true)
public class Product extends Base {

    @Column
    private String name;

    @ManyToMany(mappedBy = "productList")
    private Collection<User> userList;
    
}
