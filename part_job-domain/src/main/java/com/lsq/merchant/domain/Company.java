package com.lsq.merchant.domain;

import lombok.Data;

import java.util.Date;
@Data
/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/4/3 16:33
 
 */
public class Company {
    private Long id;

    private String account;

    private String name;

    private String type;

    private String scale;

    private String introduce;

    private String business;

    private String img;

    private String state;

    private Date registerTime;

    private String owner;

    private String tag;
}