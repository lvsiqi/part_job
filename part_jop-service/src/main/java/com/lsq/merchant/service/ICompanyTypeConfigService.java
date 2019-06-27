package com.lsq.merchant.service;

import com.lsq.merchant.bean.CompanyTypeReturn;

import java.util.List;

public interface ICompanyTypeConfigService {
    List<CompanyTypeReturn> selectAll();
}
