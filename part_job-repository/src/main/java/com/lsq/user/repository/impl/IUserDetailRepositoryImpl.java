package com.lsq.user.repository.impl;

import com.lsq.user.domain.UserDetail;
import com.lsq.user.repository.IUserDetailRepository;
import com.lsq.user.repository.mapper.UserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IUserDetailRepositoryImpl implements IUserDetailRepository {
    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public int deleteByAccount(String account) {
        return userDetailMapper.deleteByAccount(account);
    }

    @Override
    public int insert(UserDetail record) {
        return userDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(UserDetail record) {
        return userDetailMapper.insertSelective(record) ;
    }

    @Override
    public UserDetail selectByAccount(String account) {
        return userDetailMapper.selectByAccount(account);
    }

    @Override
    public int updateByAccountSelective(UserDetail record) {
        return userDetailMapper.updateByAccountSelective(record);
    }

    @Override
    public int updateByAccount(UserDetail record) {
        return userDetailMapper.updateByAccount(record);
    }
}
