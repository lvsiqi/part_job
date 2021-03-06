package com.lsq.user.repository.mapper;

import com.lsq.user.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User selectByAccount(String account);

    int updateByAccountSelective(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<String> selectAllAccount();
}