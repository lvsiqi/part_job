package com.lsq.merchant.repository.mapper;

import com.lsq.merchant.domain.Company;
import com.lsq.merchant.domain.Merchant;

public interface CompanyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Long id);

    Company  selectByAccount(String account);

    int updateByPrimaryKeySelective(Company record);

    int updateByAccountSelective(Company record);

    int updateByPrimaryKey(Company record);
}