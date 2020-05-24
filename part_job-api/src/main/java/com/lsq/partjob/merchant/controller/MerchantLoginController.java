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
 * @CreateDate: 2019/5/9 6:13
 */
@Controller
@RequestMapping(value = "/merchant")
public class MerchantLoginController {
    @Autowired
    private IMerchantService merchantService;

    @RequestMapping("login")
    @ResponseBody
    public BaseResponse Login(@RequestBody Merchant merchant) {
        return merchantService.merchantLoginCheck(merchant);
    }
}
