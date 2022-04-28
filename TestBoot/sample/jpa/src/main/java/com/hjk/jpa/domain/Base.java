package com.hjk.jpa.domain;

import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "create_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(name = "last_update_time", nullable = false)
    @CreationTimestamp
    private LocalDateTime lastUpdateTime;
}
