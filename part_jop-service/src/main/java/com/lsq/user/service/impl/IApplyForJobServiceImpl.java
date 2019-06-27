package com.lsq.user.service.impl;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.job.repository.IPartTimeJobRepository;
import com.lsq.user.bean.ApplyJobPage;
import com.lsq.user.bean.ApplyJobReturn;
import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.domain.ApplyForJob;
import com.lsq.job.repository.IApplyForJobRepository;
import com.lsq.user.service.IApplyForJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.lsq.constants.SystemConstants.SYSTEM_FAIL_KEY;
import static com.lsq.constants.SystemConstants.SYSTEM_SUCCESS_KEY;
import static com.lsq.constants.UserConstants.JOB_APPLY_ERROR_001;
import static com.lsq.constants.UserConstants.JOB_APPLY_FAIL;

/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/5/6 16:14

 */
@Service
public class IApplyForJobServiceImpl implements IApplyForJobService {
    @Autowired
    private IApplyForJobRepository applyForJobRepository;
    @Autowired
    private IPartTimeJobRepository partTimeJobRepository;
    @Override
    public SystemResponse applyJob(ApplyForJob applyForJob) {
        applyForJob.setCreateTime(new Date());
        if(applyForJobRepository.selectByPrimaryKeyAndUserAccount(applyForJob) != null){
            return new SystemResponse<>(SYSTEM_FAIL_KEY,JOB_APPLY_ERROR_001);
        }
        if(applyForJobRepository.insertSelective(applyForJob)  == 1)
        {
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY,applyForJob);
        }else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY,JOB_APPLY_FAIL);
        }
    }

    @Override
    public BaseResponse selectApplyBySearchFactor(QueryApplyJob queryApplyJob) {
        queryApplyJob.setLimitStart((queryApplyJob.getPageNum() - 1) * queryApplyJob.getPageSize());
        int total =  applyForJobRepository.selectCountBySearchFactor(queryApplyJob);
        List<ApplyForJob> applys = applyForJobRepository.selectBySearchFactor(queryApplyJob);
        List<ApplyJobReturn> results = new ArrayList<>();
        for (ApplyForJob applyForJob : applys){
            ApplyJobReturn applyJobReturn =new ApplyJobReturn();
            applyJobReturn.setApplyForJob(applyForJob);
            applyJobReturn.setPartTimeJob(partTimeJobRepository.selectByPrimaryKey(applyForJob.getJobId()));
            results.add(applyJobReturn);
        }
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY,new ApplyJobPage(total,results));
    }
}
