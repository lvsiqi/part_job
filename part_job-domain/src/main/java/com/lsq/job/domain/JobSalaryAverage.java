package com.lsq.job.domain;

import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/13 18:57
 */
@Data
public class JobSalaryAverage {
    private Long id;

    private Long jobId;

    private Float avgSalary;

    private String account;

    private String jobType;
}