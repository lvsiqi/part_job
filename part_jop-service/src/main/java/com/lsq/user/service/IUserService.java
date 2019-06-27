package com.lsq.user.service;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.user.domain.User;
import com.lsq.user.domain.UserDetail;

public interface IUserService {

    BaseResponse userLoginCheck(User user);

    BaseResponse userRegister(User user);

    BaseResponse userUpdate(User user);

    BaseResponse userCF(User user);

    BaseResponse selectByUserDetail(UserDetail userDetail);
}
