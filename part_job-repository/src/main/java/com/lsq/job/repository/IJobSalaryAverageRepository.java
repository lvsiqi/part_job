package com.lsq.job.repository;

import com.lsq.job.bean.JobTypeAvgSalary;
import com.lsq.job.domain.JobSalaryAverage;

import java.util.List;

public interface IJobSalaryAverageRepository {
    int deleteByJobId(Long id);

    int insertSelective(JobSalaryAverage record);

    JobSalaryAverage selectByPrimaryKey(Long id);

    int updateByJobIdSelective(JobSalaryAverage record);

    List<JobTypeAvgSalary> selectAvgSalaryByType();
}
