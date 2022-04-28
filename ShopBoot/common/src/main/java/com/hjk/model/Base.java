package com.hjk.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @CreationTimestamp
    @Column
    protected LocalDateTime createAt;

    @UpdateTimestamp
    @Column
    protected LocalDateTime updateAt;
    
}
