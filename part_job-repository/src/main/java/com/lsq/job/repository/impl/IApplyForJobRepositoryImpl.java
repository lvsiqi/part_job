package com.lsq.job.repository.impl;

import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.domain.ApplyForJob;
import com.lsq.job.repository.IApplyForJobRepository;
import com.lsq.job.repository.mapper.ApplyForJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IApplyForJobRepositoryImpl implements IApplyForJobRepository {
    @Autowired
    private ApplyForJobMapper applyForJobMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return applyForJobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ApplyForJob record) {
        return applyForJobMapper.insert(record);
    }

    @Override
    public int insertSelective(ApplyForJob record) {
        return applyForJobMapper.insertSelective(record);
    }

    @Override
    public ApplyForJob selectByPrimaryKey(Long id) {
        return applyForJobMapper.selectByPrimaryKey(id);
    }

    @Override
    public ApplyForJob selectByPrimaryKeyAndUserAccount(ApplyForJob queryApplyJob) {
        return applyForJobMapper.selectByPrimaryKeyAndUserAccount(queryApplyJob);
    }

    @Override
    public List<ApplyForJob> selectByMerchantAccount(String merchantAccount) {
        return applyForJobMapper.selectByMerchantAccount(merchantAccount);
    }

    @Override
    public List<ApplyForJob> selectByUserAccount(String userAccount) {
        return applyForJobMapper.selectByUserAccount(userAccount);
    }

    @Override
    public int updateByPrimaryKeySelective(ApplyForJob record) {
        return applyForJobMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<ApplyForJob> selectBySearchFactor(QueryApplyJob queryApplyJob) {
        return applyForJobMapper.selectBySearchFactor(queryApplyJob);
    }

    @Override
    public int selectCountBySearchFactor(QueryApplyJob queryApplyJob) {
        return applyForJobMapper.selectCountBySearchFactor(queryApplyJob);
    }

    @Override
    public int updateByPrimaryKey(ApplyForJob record) {
        return applyForJobMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Long> selectJobIdByUserAccount(String userAccount) {
        return applyForJobMapper.selectJobIdByUserAccount(userAccount);
    }
}
