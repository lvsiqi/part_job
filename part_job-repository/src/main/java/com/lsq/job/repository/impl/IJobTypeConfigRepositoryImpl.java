package com.lsq.job.repository.impl;

import com.lsq.job.domain.JobTypeConfig;
import com.lsq.job.repository.IJobTypeConfigRepository;
import com.lsq.job.repository.mapper.JobTypeConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class IJobTypeConfigRepositoryImpl implements IJobTypeConfigRepository {
    @Autowired
    private JobTypeConfigMapper jobTypeConfigMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return jobTypeConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(JobTypeConfig record) {
        return jobTypeConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(JobTypeConfig record) {
        return jobTypeConfigMapper.insertSelective(record);
    }

    @Override
    public List<JobTypeConfig> selectAll() {
        return jobTypeConfigMapper.selectAll();
    }

    @Override
    public JobTypeConfig selectByPrimaryKey(Long id) {
        return jobTypeConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(JobTypeConfig record) {
        return jobTypeConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JobTypeConfig record) {
        return jobTypeConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> selectByGroup(String groupName) {
        return jobTypeConfigMapper.selectByGroup(groupName);
    }

    @Override
    public List<String> selectAllGroup() {
        return jobTypeConfigMapper.selectAllGroup();
    }
}
