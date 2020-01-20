package com.springboota;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author {曹炳全}
 * @Title User
 * @Description
 * @date 2020/1/20 10:52
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "U_ID",length = 4)
    private long id;

    @Column(name = "U_NAME", nullable = false, length = 12)
    private String name;
    @Column(name = "U_PASSWORD", length = 32)
    private String password;
    @Column(name = "U_SEX", length = 1)
    private Integer sex;
    @Column(name = "U_PHOTO", length = 32)
    private String photo;
    @Column(name = "U_PHONE", length = 11)
    private String phone;
    @Column(name = "U_ADDRESS", length = 50)
    private String address;
}
