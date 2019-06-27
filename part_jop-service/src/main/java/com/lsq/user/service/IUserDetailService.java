package com.lsq.user.service;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.user.domain.UserDetail;

public interface IUserDetailService {
    BaseResponse deleteByAccount(String account);

    BaseResponse addUserDetail(UserDetail record);

    BaseResponse selectByAccount(String account);

    BaseResponse updateUserDetail(UserDetail record);
}
