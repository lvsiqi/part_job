package com.lsq.user.service.impl;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.user.domain.UserDetail;
import com.lsq.user.repository.IUserDetailRepository;
import com.lsq.user.repository.IUserRepository;
import com.lsq.user.service.IUserDetailService;
import com.lsq.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.lsq.constants.SystemConstants.SYSTEM_FAIL_KEY;
import static com.lsq.constants.SystemConstants.SYSTEM_SUCCESS_KEY;
import static com.lsq.constants.UserConstants.*;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/2 10:35
 */
@Service
public class IUserDetailServiceImpl implements IUserDetailService {
    @Autowired
    private IUserDetailRepository userDetailRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public BaseResponse deleteByAccount(String account) {
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY, userDetailRepository.deleteByAccount(account));
    }

    @Override
    public BaseResponse addUserDetail(UserDetail record) {
        if (userRepository.selectByAccount(record.getAccount()) == null) {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, USER_DETAIL_UPDATE_ERROR_001);
        }
        if (userDetailRepository.selectByAccount(record.getAccount()) != null) {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, USER_DETAIL_UPDATE_ERROR_002);
        }
        if (userDetailRepository.insertSelective(record) == 1) {
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, userDetailRepository.selectByAccount(record.getAccount()));
        } else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, USER_UPDATE_FAIL);
        }
    }

    @Override
    public BaseResponse selectByAccount(String account) {
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY, userDetailRepository.selectByAccount(account));
    }

    @Override
    public BaseResponse updateUserDetail(UserDetail record) {
        if (userDetailRepository.updateByAccountSelective(record) == 1) {
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, userDetailRepository.selectByAccount(record.getAccount()));
        } else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, USER_UPDATE_FAIL);
        }
    }
}
