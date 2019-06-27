package com.lsq.merchant.service.impl;

import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.merchant.domain.Company;
import com.lsq.merchant.repository.ICompanyRepository;
import com.lsq.merchant.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.lsq.constants.MerchantConstants.* ;
import static com.lsq.constants.SystemConstants.*;

/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/4/3 16:52

 */
@Service
public class ICompanyServiceImpl implements ICompanyService {
    @Autowired
    private ICompanyRepository companyRepository;
    @Override
    public SystemResponse addCompany(Company company) {
        if(companyRepository.selectByAccount(company.getAccount())!= null){
            return new SystemResponse(SYSTEM_FAIL_KEY,COMPANY_ADD_ERROR_001);
        }
        if(companyRepository.insertSelective(company) == 1){
            return new SystemResponse(SYSTEM_SUCCESS_KEY,company);
        }else {
            return new SystemResponse(SYSTEM_FAIL_KEY,company);
        }
    }

    @Override
    public SystemResponse updateCompany(Company company) {
        if(companyRepository.updateByAccountSelective(company) == 1){
            return new SystemResponse(SYSTEM_SUCCESS_KEY,company);
        }else {
            return new SystemResponse(SYSTEM_FAIL_KEY,company);
        }
    }

    @Override
    public Company selectCompany(String account){
        return companyRepository.selectByAccount(account);
    }
}
