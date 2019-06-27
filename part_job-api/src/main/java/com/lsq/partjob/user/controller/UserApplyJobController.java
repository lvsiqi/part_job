package com.lsq.partjob.user.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.message.domain.MyMessages;
import com.lsq.message.service.IMessageService;
import com.lsq.partjob.websocket.controller.WebSocketServer;
import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.domain.ApplyForJob;
import com.lsq.user.service.IApplyForJobService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import static com.lsq.constants.Message.*;
import static com.lsq.constants.SystemConstants.SYSTEM_SUCCESS_KEY;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/6 16:27
 */
@Controller
@RequestMapping("/user/apply_job")
public class UserApplyJobController {
    @Autowired
    private IApplyForJobService applyForJobService;

    @Autowired
    private IMessageService messageService;

    @RequestMapping("/apply")
    @ResponseBody
    public BaseResponse applyJob(@RequestBody  ApplyForJob applyForJob) {
        SystemResponse result = applyForJobService.applyJob(applyForJob);
        if(StringUtils.equals(result.getState(),SYSTEM_SUCCESS_KEY)){
            MyMessages systemMessage = new MyMessages();
            systemMessage.setType(MESSAGE_TYPE_SYSTEM);
            systemMessage.setState(MESSAGE_STATE_UNREAD);
            systemMessage.setSendAccount(applyForJob.getUserAccount());
            systemMessage.setAcceptAccount(applyForJob.getMerchantAccount());
            systemMessage.setContent("用户"+applyForJob.getUserAccount()+"申请了工作");
            systemMessage.setCreateTime(new Date());
            messageService.add(systemMessage);
            WebSocketServer.sendInfo(systemMessage);
        }
        return result;
    }

    @RequestMapping("/select_apply_by_factor")
    @ResponseBody
    public BaseResponse selectByMerchantAccount(@RequestBody  QueryApplyJob queryApplyJob){
        return applyForJobService.selectApplyBySearchFactor(queryApplyJob);
    }
}
