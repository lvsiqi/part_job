package com.lsq.merchant.repository;

import com.lsq.merchant.domain.Company;

public interface ICompanyRepository {
    int insertSelective(Company record);

    int updateByAccountSelective(Company record);

    Company  selectByAccount(String account);
}
