package com.konvi.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 管理员登录
 */

@Entity
@Data
@Table(name = "users")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * 用户标识
     */
    @Column(name = "user_id")
    private String userid;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String username;

    /**
     * 用户登录密码
     */
    @Column(name = "user_password")
    private String password;

    /**
     * 用户备注
     */
    private String userRemarks;


}

