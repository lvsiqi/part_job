package com.lsq.user.repository.mapper;

import com.lsq.user.domain.UserDetail;

public interface UserDetailMapper {
    int deleteByAccount(String account);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByAccount(String account);

    int updateByAccountSelective(UserDetail record);

    int updateByAccount(UserDetail record);
}