package com.lsq.job.domain;

import lombok.Data;

import java.util.Date;
/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/5/7 16:52
 
 */
@Data
public class PartTimeJob {
    private Long id;

    private String name;

    private String account;

    private String companyScale;

    private String companyName;

    private String type;

    private String work;

    private String require;

    private String area;

    private String address;

    private String salary;

    private float  avgSalary;

    private String payMethod;

    private Integer peopleNum;

    private Date startTime;

    private String describe;

    private Date createTime;

    private Date updateTime;

    private String jobNature;

    private String state;

    private Date endTime;

    private void setSalary(String salary){
        this.salary = salary;
        String[] salaryArray = salary.split("/");
        float temp = Float.parseFloat(salaryArray[0]);
        if("小时".equals(salaryArray[1])){
            this.avgSalary = temp * 8;
        }else if("天".equals(salaryArray[1])){
            this.avgSalary = temp;
        }else if("月".equals(salaryArray[1])){
            this.avgSalary = temp / 30;
        }
    }
}