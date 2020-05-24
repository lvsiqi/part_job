package com.lsq.job.service.impl;

import com.lsq.job.bean.CityReturn;
import com.lsq.job.domain.CityConfig;
import com.lsq.job.repository.ICityConfigRepository;
import com.lsq.job.service.ICityConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/7 14:48
 */
@Service
public class ICityConfigServiceImpl implements ICityConfigService {
    @Autowired
    private ICityConfigRepository cityConfigRepository;

    @Override
    public List<CityReturn> selectAllArea() {
        List<CityConfig> temps = cityConfigRepository.selectAll();
        ArrayList<CityReturn> results = new ArrayList<>();
        Map<String, ArrayList<String>> tempMap = new HashMap<>(5);
        for (CityConfig temp : temps) {
            boolean flag = true;
            for (Map.Entry<String, ArrayList<String>> entry : tempMap.entrySet()) {
                if (entry.getKey().equals(temp.getCity())) {
                    tempMap.get(temp.getCity()).add(temp.getArea());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ArrayList<String> a = new ArrayList<>();
                a.add(temp.getArea());
                tempMap.put(temp.getCity(), a);
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : tempMap.entrySet()) {
            CityReturn cityReturn = new CityReturn();
            cityReturn.setCity(entry.getKey());
            cityReturn.setArea(entry.getValue());
            results.add(cityReturn);
        }

        return results;
    }
}
