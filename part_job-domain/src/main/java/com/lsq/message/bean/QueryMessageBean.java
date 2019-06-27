package com.lsq.message.bean;

import lombok.Data;

import java.util.Date;

@Data
public class QueryMessageBean {
  private Long id;

  private String sendAccount;

  private String acceptAccount;

  private String state;

  private String type;

  private Date createDate;
}
