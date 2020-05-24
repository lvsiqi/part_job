package com.lsq.job.bean;

import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/24 9:48
 */
@Data
public class QueryPageBean {

    private String account;

    private String jobName;

    private String jobType;

    private String jobArea;

    private String jobPayMethod;

    private String jobNature;

    private String sortMethod;

    private String sortFlag;

    private int pageNum;

    private int pageSize;

    private int limitStart;

    private String modelFlag;
}
