package com.lsq.merchant.repository.impl;

import com.lsq.merchant.domain.Company;
import com.lsq.merchant.repository.ICompanyRepository;
import com.lsq.merchant.repository.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ICompanyRepositoryImpl implements ICompanyRepository {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int insertSelective(Company record) {
        return companyMapper.insertSelective(record);
    }

    @Override
    public int updateByAccountSelective(Company record) {
        return companyMapper.updateByAccountSelective(record);
    }

    @Override
    public Company selectByAccount(String account) {
        return companyMapper.selectByAccount(account);
    }
}
