package com.lsq.merchant.service.impl;

import com.lsq.merchant.bean.CompanyTypeReturn;
import com.lsq.merchant.domain.CompanyTypeConfig;
import com.lsq.merchant.repository.ICompanyTypeConfigRepository;
import com.lsq.merchant.service.ICompanyTypeConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ICompanyTypeConfigServiceImpl implements ICompanyTypeConfigService {
    @Autowired
    private ICompanyTypeConfigRepository companyTypeConfigRepository;
    @Override
    public List<CompanyTypeReturn> selectAll() {
        List<CompanyTypeConfig> temps = companyTypeConfigRepository.selectAll();
        ArrayList<CompanyTypeReturn> results = new ArrayList<>();
        Map<String,ArrayList<String>> tempMap = new HashMap<>(5);
        for(CompanyTypeConfig temp : temps)
        {
            boolean flag = true;
            for (Map.Entry<String,ArrayList<String>> entry : tempMap.entrySet()) {
                if(entry.getKey().equals(temp.getGroup())){
                    tempMap.get(temp.getGroup()).add(temp.getValue());
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ArrayList<String> a = new ArrayList<>();
                a.add(temp.getValue());
                tempMap.put(temp.getGroup(),a);
            }
        }
        for (Map.Entry<String,ArrayList<String>> entry : tempMap.entrySet()) {
              CompanyTypeReturn companyTypeReturn =new CompanyTypeReturn();
              companyTypeReturn.setGroup(entry.getKey());
              companyTypeReturn.setValues(entry.getValue());
              results.add(companyTypeReturn);
            }

        return results;
    }
}
