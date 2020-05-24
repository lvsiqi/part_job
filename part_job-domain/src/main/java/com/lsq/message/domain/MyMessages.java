package com.lsq.message.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MyMessages {
    private Long id;

    private String content;

    private String sendAccount;

    private String acceptAccount;

    private String type;

    private String state;

    private String extra;

    private Date createTime;
}