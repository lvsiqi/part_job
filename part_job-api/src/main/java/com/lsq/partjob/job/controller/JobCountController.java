package com.lsq.partjob.job.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.job.service.IPartTimeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/5/18 0:53
 
 */
@Controller
@RequestMapping("/job_count")
@ResponseBody
public class JobCountController {
    @Autowired
    private IPartTimeJobService partTimeJobService;
    @RequestMapping("/avg_salary_by_type")
    public BaseResponse selectAvgSalaryByType(){
        return partTimeJobService.selectAvgSalaryByType();
    }
}

