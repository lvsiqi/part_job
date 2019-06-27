package com.lsq.partjob.admin.controller;

import com.lsq.admin.bean.AdminLoginReturn;
import com.lsq.admin.domain.Admin;
import com.lsq.admin.service.IAdminService;
import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.lsq.constants.LoginConstants.*;
/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/5/6 16:20

 */
@Controller
@RequestMapping(value = "/admin")
public class AdminLoginController {
    @Autowired
    private IAdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public BaseResponse  Login(@RequestBody  @Valid Admin admin, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<String> errorList = new ArrayList<String>();
            for(FieldError error : bindingResult.getFieldErrors())
            {
                errorList.add(error.getDefaultMessage());
            }
            return new LoginResponse(LOGIN_FAIL_KEY, new AdminLoginReturn(admin.getAccount(),UNREGISTERED_ROLE_KEY,errorList.toString()));
        }
            return adminService.adminLoginCheck(admin);
    }
}
