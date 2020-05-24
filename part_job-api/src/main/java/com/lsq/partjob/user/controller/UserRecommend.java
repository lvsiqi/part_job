package com.lsq.partjob.user.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.user.domain.User;
import com.lsq.user.domain.UserDetail;
import com.lsq.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserRecommend {
    @Autowired
    private IUserService userService;

    @RequestMapping("/recommend/userCF")
    @ResponseBody
    public BaseResponse recommend(@RequestBody User user) {
        return userService.userCF(user);
    }

    @RequestMapping("recommend/by_job_type")
    @ResponseBody
    public BaseResponse recommendByJobType(@RequestBody UserDetail userDetail) {
        return userService.selectByUserDetail(userDetail);
    }
}
