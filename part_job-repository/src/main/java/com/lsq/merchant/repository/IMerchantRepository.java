package com.lsq.merchant.repository;

import com.lsq.merchant.domain.Merchant;

public interface IMerchantRepository {
    int deleteByPrimaryKey(Long id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Long id);

    Merchant selectByAccount(String account);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}
