package com.lsq.partjob.user.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.user.bean.QueryLabel;
import com.lsq.user.service.IUserLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/29 13:46
 */
@Controller
@RequestMapping("/user_label")
public class UserLabelController {
    @Autowired
    private IUserLabelService userLabelService;

    @RequestMapping("/get_all_group")
    @ResponseBody
    public BaseResponse getAllGroup() {
        return userLabelService.getAllGroup();
    }

    @RequestMapping("/get_label_by_group")
    @ResponseBody
    public BaseResponse getLabelByGroup(@RequestBody QueryLabel queryLabel) {
        return userLabelService.getLabelByGroup(queryLabel);
    }
}
