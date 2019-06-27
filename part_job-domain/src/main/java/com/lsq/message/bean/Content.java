package com.lsq.message.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Content {
    private String text;

    private String flag;

    private Date createTime;
}
