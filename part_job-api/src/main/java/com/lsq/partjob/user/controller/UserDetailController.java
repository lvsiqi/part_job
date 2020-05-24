package com.lsq.partjob.user.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.user.domain.UserDetail;
import com.lsq.user.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/2 10:44
 */
@Controller
@RequestMapping("/user_detail")
public class UserDetailController {
    @Autowired
    private IUserDetailService userDetailService;

    @RequestMapping("/add")
    @ResponseBody
    public BaseResponse userDetailAdd(@RequestBody UserDetail userDetail) {
        userDetail.labelConvert();
        return userDetailService.addUserDetail(userDetail);
    }

    @RequestMapping("/update")
    @ResponseBody
    public BaseResponse userDetailUpdate(@RequestBody UserDetail userDetail) {
        userDetail.labelConvert();
        return userDetailService.updateUserDetail(userDetail);
    }
}
