package com.lsq.user.service;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.domain.ApplyForJob;
/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/5/6 16:13

 */
public interface IApplyForJobService {

      SystemResponse applyJob(ApplyForJob applyForJob);

      BaseResponse selectApplyBySearchFactor(QueryApplyJob queryApplyJob);
}
