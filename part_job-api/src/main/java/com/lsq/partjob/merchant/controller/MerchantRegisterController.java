package com.lsq.partjob.merchant.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.merchant.domain.Merchant;
import com.lsq.merchant.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/3/25 10:51
 */
@Controller
@RequestMapping("/merchant")
public class MerchantRegisterController {
    @Autowired
    private IMerchantService merchantService;

    @RequestMapping("/register")
    @ResponseBody
    public BaseResponse register(@RequestBody Merchant merchant) {
        return merchantService.merchantRegister(merchant);
    }
}
