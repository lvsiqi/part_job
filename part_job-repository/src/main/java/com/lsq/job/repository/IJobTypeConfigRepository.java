package com.lsq.job.repository;

import com.lsq.job.domain.JobTypeConfig;

import java.util.List;

public interface IJobTypeConfigRepository {
    int deleteByPrimaryKey(Long id);

    int insert(JobTypeConfig record);

    int insertSelective(JobTypeConfig record);

    List<JobTypeConfig> selectAll();

    JobTypeConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JobTypeConfig record);

    int updateByPrimaryKey(JobTypeConfig record);

    List<String> selectByGroup(String groupName);

    List<String> selectAllGroup();
}
