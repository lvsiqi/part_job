package com.lsq.partjob.user.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.user.domain.User;
import com.lsq.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/21 21:33
 */
@Controller
@RequestMapping("/user")
public class UserBaseController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public BaseResponse login(@RequestBody User user) {
        return userService.userLoginCheck(user);
    }

    @RequestMapping("/register")
    @ResponseBody
    public BaseResponse register(@RequestBody User user) {
        return userService.userRegister(user);
    }

    @RequestMapping("/update")
    @ResponseBody
    public BaseResponse update(@RequestBody User user) {
        return userService.userUpdate(user);
    }
}
