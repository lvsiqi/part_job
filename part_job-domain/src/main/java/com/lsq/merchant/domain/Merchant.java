package com.lsq.merchant.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Merchant {
    private Long id;

    private String headImg;

    private String account;

    private String password;

    private String name;

    private String tel;

    private String address;

    private String type;

    private String scale;

    private String introduce;

    private String state;

    private Date createTime;

    private Date updateTime;

   }