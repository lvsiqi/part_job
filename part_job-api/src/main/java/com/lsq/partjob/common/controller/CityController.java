package com.lsq.partjob.common.controller;

import com.lsq.job.bean.CityReturn;
import com.lsq.job.service.ICityConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/7 16:52
 */
@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityConfigService cityConfigService;

    @RequestMapping("/get_all_area")
    @ResponseBody
    public List<CityReturn> getAllArea() {
        return cityConfigService.selectAllArea();
    }
}
