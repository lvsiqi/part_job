package com.lsq.job.service;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.job.bean.JobPageBean;
import com.lsq.job.bean.JobTypeAvgSalary;
import com.lsq.job.bean.JobTypeReturn;
import com.lsq.job.bean.QueryPageBean;
import com.lsq.job.domain.PartTimeJob;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/24 9:41
 */
public interface IPartTimeJobService {
    BaseResponse addPartTimeJob(PartTimeJob partTimeJob);

    BaseResponse selectJobPageByAccount(QueryPageBean queryPageBean);

    List<JobTypeReturn> selectAllJobType();

    BaseResponse deleteById(Long id);

    BaseResponse updateById(PartTimeJob record);

    BaseResponse selectJobPageByName(QueryPageBean queryPageBean);

    BaseResponse selectJobPageAll(QueryPageBean queryPageBean);

    BaseResponse selectPageByFactor(QueryPageBean queryPageBean);

    BaseResponse selectAvgSalaryByType();
}
