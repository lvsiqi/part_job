package com.lsq.user.bean;

import lombok.Data;

@Data
public class QueryApplyJob {
    private  Long id;

    private  Long jobId;

    private  String merchantAccount;

    private  String userAccount;

    private  String state;

    private int pageNum;

    private int pageSize;

    private int limitStart;
}
