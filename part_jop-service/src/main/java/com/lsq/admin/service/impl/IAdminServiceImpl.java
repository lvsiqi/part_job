package com.lsq.admin.service.impl;

import com.lsq.admin.bean.AdminLoginReturn;
import com.lsq.admin.domain.Admin;
import com.lsq.admin.repository.IAdminRepository;
import com.lsq.admin.service.IAdminService;
import com.lsq.basebean.baseresponse.LoginResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.lsq.constants.LoginConstants.*;

@Service
public class IAdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminRepository adminRepository;

    @Override
    public int deleteById(Integer id) {
        return adminRepository.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return adminRepository.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminRepository.insertSelective(record);
    }

    @Override
    public Admin selectByID(Integer id) {
        return adminRepository.selectByPrimaryKey(id);
    }

    @Override
    public LoginResponse adminLoginCheck( Admin admin) {
        Admin result = adminRepository.selectByAccount(admin.getAccount());
        if (result == null) {
            AdminLoginReturn adminLoginReturn = new AdminLoginReturn(admin.getAccount(), UNREGISTERED_ROLE_KEY, LOGIN_ERROR_001);
            return new LoginResponse(LOGIN_FAIL_KEY, adminLoginReturn);
        }
        if (StringUtils.equals(admin.getPassword(), result.getPassword())) {
            AdminLoginReturn adminLoginReturn = new AdminLoginReturn(admin.getAccount(), ADMIN_ROLE_KEY, LOGIN_SUCCESS_DESCRIPTION);
            return new LoginResponse(LOGIN_SUCCESS_KEY, adminLoginReturn);
        } else {
            AdminLoginReturn adminLoginReturn = new AdminLoginReturn(admin.getAccount(), ADMIN_ROLE_KEY, LOGIN_ERROR_002);
            return new LoginResponse(LOGIN_FAIL_KEY, adminLoginReturn);
        }

    }

    @Override
    public int updateByIdSelective(Admin record) {
        return adminRepository.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Admin record) {
        return adminRepository.updateByPrimaryKey(record);
    }
}
