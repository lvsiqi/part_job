package com.lsq.job.repository;

import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.domain.ApplyForJob;

import java.util.List;

public interface IApplyForJobRepository {
    int deleteByPrimaryKey(Long id);

    int insert(ApplyForJob record);

    int insertSelective(ApplyForJob record);

    ApplyForJob selectByPrimaryKey(Long id);

    ApplyForJob selectByPrimaryKeyAndUserAccount(ApplyForJob queryApplyJob);

    List<ApplyForJob> selectByMerchantAccount(String merchantAccount);

    List<ApplyForJob> selectByUserAccount(String userAccount);

    int updateByPrimaryKeySelective(ApplyForJob record);

    List<ApplyForJob> selectBySearchFactor(QueryApplyJob queryApplyJob);

    int selectCountBySearchFactor(QueryApplyJob queryApplyJob);

    int updateByPrimaryKey(ApplyForJob record);

    List<Long> selectJobIdByUserAccount(String userAccount);
}
