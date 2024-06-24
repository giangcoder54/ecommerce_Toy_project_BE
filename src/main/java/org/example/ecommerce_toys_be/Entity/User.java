package org.example.ecommerce_toys_be.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false, length = 100)
    private String id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "USER_NAME", nullable = false, length = 100,unique = true)
    private String userName;

    @Column(name = "FULL_NAME", nullable = false, length = 100)
    private String fullName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "MOBILE", nullable = false, length = 20)
    private String mobile;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Lob
    //@Column(name = "PHOTO", nullable = false)
    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Long birthDate;

    @Column(name = "GENDER")
    private String gender;


    @Column(name = "STATUS", nullable = false)
    private String status;


}