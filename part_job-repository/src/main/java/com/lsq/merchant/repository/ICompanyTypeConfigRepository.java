package com.lsq.merchant.repository;

import com.lsq.merchant.domain.CompanyTypeConfig;

import java.util.List;

public interface ICompanyTypeConfigRepository {
    int deleteByPrimaryKey(Long id);

    int insert(CompanyTypeConfig record);

    int insertSelective(CompanyTypeConfig record);

    CompanyTypeConfig selectByPrimaryKey(Long id);

    List<CompanyTypeConfig> selectAll();

    int updateByPrimaryKeySelective(CompanyTypeConfig record);

    int updateByPrimaryKey(CompanyTypeConfig record);
}
