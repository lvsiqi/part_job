package com.lsq.merchant.service;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.domain.ApplyForJob;

public interface IApplyUserService {
    BaseResponse searchApplyUserByFactor(QueryApplyJob queryApplyJob);

    SystemResponse updateApply(ApplyForJob applyForJob);
}
