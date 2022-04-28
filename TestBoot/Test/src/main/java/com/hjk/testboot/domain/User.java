package com.hjk.testboot.domain;


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

    @Column(name = "USER_ID", nullable = false)
    private String userid;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;
}
