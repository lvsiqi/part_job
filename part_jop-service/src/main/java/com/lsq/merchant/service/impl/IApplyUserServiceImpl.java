package com.lsq.merchant.service.impl;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.job.repository.IApplyForJobRepository;
import com.lsq.job.repository.IPartTimeJobRepository;
import com.lsq.merchant.service.IApplyUserService;
import com.lsq.user.bean.ApplyJobPage;
import com.lsq.user.bean.ApplyJobReturn;
import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.domain.ApplyForJob;
import com.lsq.user.repository.IUserDetailRepository;
import com.lsq.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.lsq.constants.SystemConstants.SYSTEM_FAIL_KEY;
import static com.lsq.constants.SystemConstants.SYSTEM_SUCCESS_KEY;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/10 17:03
 */
@Service
public class IApplyUserServiceImpl implements IApplyUserService {
    @Autowired
    private IApplyForJobRepository applyForJobRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IPartTimeJobRepository partTimeJobRepository;
    @Autowired
    private IUserDetailRepository userDetailRepository;

    @Override
    public BaseResponse searchApplyUserByFactor(QueryApplyJob queryApplyJob) {
        queryApplyJob.setLimitStart((queryApplyJob.getPageNum() - 1) * queryApplyJob.getPageSize());
        int total = applyForJobRepository.selectCountBySearchFactor(queryApplyJob);
        List<ApplyForJob> applys = applyForJobRepository.selectBySearchFactor(queryApplyJob);
        List<ApplyJobReturn> results = new ArrayList<>();
        for (ApplyForJob applyForJob : applys) {
            ApplyJobReturn applyJobReturn = new ApplyJobReturn();
            applyJobReturn.setApplyForJob(applyForJob);
            applyJobReturn.setPartTimeJob(partTimeJobRepository.selectByPrimaryKey(applyForJob.getJobId()));
            applyJobReturn.setUser(userRepository.selectByAccount(applyForJob.getUserAccount()));
            applyJobReturn.setUserDetail(userDetailRepository.selectByAccount(applyForJob.getUserAccount()));
            results.add(applyJobReturn);
        }
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY, new ApplyJobPage(total, results));
    }

    @Override
    public SystemResponse updateApply(ApplyForJob applyForJob) {
        if (applyForJobRepository.updateByPrimaryKey(applyForJob) == 1) {
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, applyForJob);
        } else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, applyForJob);
        }
    }
}
