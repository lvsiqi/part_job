package com.lsq.user.domain;

import lombok.Data;

import java.util.Date;

@Data
/**
 * @Description: java类作用描述

 * @Author: lvsiqi

 * @CreateDate: 2019/4/21 20:17

 */
public class User {
    private Long id;

    private String account;

    private String password;

    private String headImg;

    private String name;

    private String sex;

    private String age;

    private String tel;

    private String address;

    private String state;

    private Date createTime;

    private Date updateTime;
}