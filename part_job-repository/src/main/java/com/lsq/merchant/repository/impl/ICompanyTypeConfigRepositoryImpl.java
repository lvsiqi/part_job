package com.lsq.merchant.repository.impl;

import com.lsq.merchant.domain.CompanyTypeConfig;
import com.lsq.merchant.repository.ICompanyTypeConfigRepository;
import com.lsq.merchant.repository.mapper.CompanyTypeConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ICompanyTypeConfigRepositoryImpl implements ICompanyTypeConfigRepository {
    @Autowired
    private CompanyTypeConfigMapper companyTypeConfigMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(CompanyTypeConfig record) {
        return 0;
    }

    @Override
    public int insertSelective(CompanyTypeConfig record) {
        return 0;
    }

    @Override
    public CompanyTypeConfig selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<CompanyTypeConfig> selectAll() {
        return companyTypeConfigMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(CompanyTypeConfig record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CompanyTypeConfig record) {
        return 0;
    }
}
