package com.lsq.user.domain;

import lombok.Data;
/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/5/6 15:20
 
 */
import java.util.Date;
@Data
public class ApplyForJob {
    private Long id;

    private Long jobId;

    private String userAccount;

    private String merchantAccount;

    private String state;

    private Date createTime;

    private Date updateTime;
}