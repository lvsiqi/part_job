package com.lsq.merchant.repository.impl;

import com.lsq.merchant.domain.Merchant;
import com.lsq.merchant.repository.IMerchantRepository;
import com.lsq.merchant.repository.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IMerchantRepositoryImpl implements IMerchantRepository {
    @Autowired
    private MerchantMapper merchantMapper;
    @Override
    public int deleteByPrimaryKey(Long id){
        return merchantMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Merchant record) {
        return merchantMapper.insert(record);
    }

    @Override
    public int insertSelective(Merchant record) {
        return merchantMapper.insertSelective(record);
    }

    @Override
    public Merchant selectByPrimaryKey(Long id) {
        return merchantMapper.selectByPrimaryKey(id);
    }

    @Override
    public  Merchant selectByAccount(String account){
        return merchantMapper.selectByAccount(account);
    }

    @Override
    public int updateByPrimaryKeySelective(Merchant record) {
        return merchantMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Merchant record) {
        return merchantMapper.updateByPrimaryKey(record);
    }
}
