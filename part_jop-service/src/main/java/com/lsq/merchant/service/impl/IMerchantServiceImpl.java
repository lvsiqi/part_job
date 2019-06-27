package com.lsq.merchant.service.impl;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.LoginResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.merchant.bean.MerchantCommonReturn;
import com.lsq.merchant.bean.MerchantData;
import com.lsq.merchant.bean.MerchantLoginReturn;
import com.lsq.merchant.domain.Company;
import com.lsq.merchant.domain.Merchant;
import com.lsq.merchant.repository.ICompanyRepository;
import com.lsq.merchant.repository.IMerchantRepository;
import com.lsq.merchant.service.IMerchantService;
import com.lsq.message.repository.IMyMessagesRepository;
import com.lsq.user.domain.User;
import com.lsq.user.repository.IUserRepository;
import com.lsq.user.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.lsq.constants.LoginConstants.*;
import static com.lsq.constants.MerchantConstants.*;
import static com.lsq.constants.SystemConstants.*;
/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/3/25 10:53

 */
@Service
public class IMerchantServiceImpl implements IMerchantService {
    @Autowired
    private IMerchantRepository merchantRepository;
    @Autowired
    private ICompanyRepository companyRepository;
    @Autowired
    private IUserRepository userRepository;
    @Override
    public int deleteByID(Long id) {
        return merchantRepository.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Merchant record) {
        return merchantRepository.insert(record);
    }

    @Override
    public SystemResponse merchantRegister(Merchant record) {
        Merchant db =merchantRepository.selectByAccount(record.getAccount());
        User db2 = userRepository.selectByAccount(record.getAccount());
        if(db != null || db2 != null)
        {
            return new SystemResponse(SYSTEM_FAIL_KEY,new MerchantCommonReturn(record.getAccount(),MERCHANT_REGISTER_ERROR_001));
        }
        record.setState(MERCHANT_STATE_001);
        record.setCreateTime(new Date());
        if(merchantRepository.insertSelective(record) == 1){
            return new SystemResponse(SYSTEM_SUCCESS_KEY,new MerchantCommonReturn(record.getAccount(),MERCHANT_REGISTER_SUCESS));
        }
        else {
            return new SystemResponse(SYSTEM_FAIL_KEY,new MerchantCommonReturn(record.getAccount(),MERCHANT_REGISTER_FAIL));
        }
    }

    @Override
    public Merchant selectById(Long id) {
        return merchantRepository.selectByPrimaryKey(id);
    }

    @Override
    public LoginResponse merchantLoginCheck(Merchant merchant) {
        Merchant result = merchantRepository.selectByAccount(merchant.getAccount());
        Company company = companyRepository.selectByAccount(merchant.getAccount());
        if(company == null) {
            company = new Company();
        }
        if (result == null) {
            MerchantLoginReturn merchantLoginReturn = new MerchantLoginReturn(merchant.getAccount(), UNREGISTERED_ROLE_KEY, LOGIN_ERROR_001,null,null);
            return new LoginResponse(LOGIN_FAIL_KEY, merchantLoginReturn);
        }
        if (StringUtils.equals(merchant.getPassword(), result.getPassword())) {
            MerchantLoginReturn merchantLoginReturn = new MerchantLoginReturn(merchant.getAccount(), MERCHANT_ROLE_KEY, LOGIN_SUCCESS_DESCRIPTION,result,company);
            return new LoginResponse(LOGIN_SUCCESS_KEY, merchantLoginReturn);
        } else {
            MerchantLoginReturn merchantLoginReturn = new MerchantLoginReturn(merchant.getAccount(), MERCHANT_ROLE_KEY, LOGIN_ERROR_002,null,null);
            return new LoginResponse(LOGIN_FAIL_KEY, merchantLoginReturn);
        }

    }

    @Override
    public SystemResponse updateByIdSelective(Merchant record) {
        record.setUpdateTime(new Date());
        if(merchantRepository.updateByPrimaryKeySelective(record) == 1){
            return new SystemResponse(SYSTEM_SUCCESS_KEY,new MerchantCommonReturn(record.getAccount(),MERCHANT_UPDATE_SUCESS));
        }
        else {
            return new SystemResponse(SYSTEM_FAIL_KEY,new MerchantCommonReturn(record.getAccount(),MERCHANT_UPDATE_FAIL));
        }
    }

    @Override
    public BaseResponse getMerchantData(Merchant merchant) {
        MerchantData merchantData = new MerchantData();
        merchantData.setMerchant(merchantRepository.selectByAccount(merchant.getAccount()));
        merchantData.setCompany(companyRepository.selectByAccount(merchant.getAccount()));
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY,merchantData);
    }

    @Override
    public int updateById(Merchant record) {
        return 0;
    }
}
