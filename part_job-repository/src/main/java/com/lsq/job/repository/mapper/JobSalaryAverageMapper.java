package com.lsq.job.repository.mapper;

import com.lsq.job.bean.JobTypeAvgSalary;
import com.lsq.job.domain.JobSalaryAverage;

import java.util.List;

public interface JobSalaryAverageMapper {
    int deleteByJobId(Long jobId);

    int insertSelective(JobSalaryAverage record);

    JobSalaryAverage selectByPrimaryKey(Long id);

    int updateByJobIdSelective(JobSalaryAverage record);

    List<JobTypeAvgSalary> selectAvgSalaryByType();

}