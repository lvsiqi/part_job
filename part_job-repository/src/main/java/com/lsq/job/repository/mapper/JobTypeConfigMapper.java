package com.lsq.job.repository.mapper;

import com.lsq.job.domain.JobTypeConfig;

import java.util.List;

public interface JobTypeConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JobTypeConfig record);

    int insertSelective(JobTypeConfig record);

    List<JobTypeConfig> selectAll();

    JobTypeConfig selectByPrimaryKey(Long id);

    List<String> selectByGroup(String groupName);

    List<String> selectAllGroup();

    int updateByPrimaryKeySelective(JobTypeConfig record);

    int updateByPrimaryKey(JobTypeConfig record);
}