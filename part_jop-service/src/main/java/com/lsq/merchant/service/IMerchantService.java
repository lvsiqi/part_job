package com.lsq.merchant.service;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.LoginResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.merchant.domain.Merchant;

public interface IMerchantService {
    int deleteByID(Long id);

    int insert(Merchant record);

    SystemResponse merchantRegister(Merchant record);

    Merchant selectById(Long id);

    LoginResponse merchantLoginCheck(Merchant merchant);

    SystemResponse updateByIdSelective(Merchant record);

    BaseResponse getMerchantData(Merchant merchant);

    int updateById(Merchant record);
}
