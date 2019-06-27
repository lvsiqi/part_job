package com.lsq.admin.service;

import com.lsq.admin.domain.Admin;
import com.lsq.basebean.baseresponse.LoginResponse;

public interface IAdminService {
    int deleteById(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByID(Integer id);

    LoginResponse adminLoginCheck(Admin admin);

    int updateByIdSelective(Admin record);

    int updateById(Admin record);
}
