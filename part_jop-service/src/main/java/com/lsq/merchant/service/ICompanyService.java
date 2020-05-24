package com.lsq.merchant.service;

import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.merchant.domain.Company;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/3 16:45
 */
public interface ICompanyService {
    SystemResponse addCompany(Company company);

    SystemResponse updateCompany(Company company);

    Company selectCompany(String account);
}
