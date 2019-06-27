package com.lsq.partjob.merchant.controller;

import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.merchant.bean.CompanyTypeReturn;
import com.lsq.merchant.domain.Company;
import com.lsq.merchant.service.ICompanyService;
import com.lsq.merchant.service.ICompanyTypeConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/3 18:29
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private ICompanyTypeConfigService companyTypeConfigService;

    @RequestMapping("/add_company")
    @ResponseBody
    public SystemResponse addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @RequestMapping("/update_company")
    @ResponseBody
    public SystemResponse updateCompany(@RequestBody Company company){
        return  companyService.updateCompany(company);
    }

    @RequestMapping("/get_company_type")
    @ResponseBody
    public List<CompanyTypeReturn> getCompanyType() {
        return companyTypeConfigService.selectAll();
    }
}
