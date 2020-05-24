package com.lsq.admin.repository.mapper;

import com.lsq.admin.domain.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    Admin selectByAccount(String account);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}