package com.lsq.job.repository.impl;

import com.lsq.job.bean.JobTypeAvgSalary;
import com.lsq.job.domain.JobSalaryAverage;
import com.lsq.job.repository.IJobSalaryAverageRepository;
import com.lsq.job.repository.mapper.JobSalaryAverageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IJobSalaryAverageRepositoryImpl implements IJobSalaryAverageRepository {
    @Autowired
    private JobSalaryAverageMapper jobSalaryAverageMapper;
    @Override
    public int deleteByJobId(Long id) {
        return jobSalaryAverageMapper.deleteByJobId(id);
    }

    @Override
    public int insertSelective(JobSalaryAverage record) {
        return jobSalaryAverageMapper.insertSelective(record);
    }

    @Override
    public JobSalaryAverage selectByPrimaryKey(Long id) {
        return jobSalaryAverageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByJobIdSelective(JobSalaryAverage record) {
        return jobSalaryAverageMapper.updateByJobIdSelective(record);
    }

    @Override
    public List<JobTypeAvgSalary> selectAvgSalaryByType() {
        return jobSalaryAverageMapper.selectAvgSalaryByType();
    }
}
