package com.lsq.partjob.merchant.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.merchant.domain.Merchant;
import com.lsq.merchant.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.lsq.constants.MerchantConstants.MERCHANT_STATE_002;

/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/4/1 16:59
 
 */
@Controller
@RequestMapping("/merchant")
public class MerchantBaseController {
    @Autowired
    private IMerchantService merchantService;
    @RequestMapping("/update")
    @ResponseBody
    public BaseResponse update(@RequestBody Merchant merchant) {
        merchant.setState(MERCHANT_STATE_002);
        return merchantService.updateByIdSelective(merchant);
    }

    @RequestMapping("/get_merchant_data_by_account")
    @ResponseBody
    public BaseResponse getMerchantData(@RequestBody Merchant merchant) {
        return merchantService.getMerchantData(merchant);
    }
}
