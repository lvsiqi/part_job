package com.lsq.partjob.merchant.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.merchant.service.IApplyUserService;
import com.lsq.message.domain.MyMessages;
import com.lsq.message.service.IMessageService;
import com.lsq.partjob.websocket.controller.WebSocketServer;
import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.domain.ApplyForJob;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import static com.lsq.constants.Message.*;
import static com.lsq.constants.Message.MESSAGE_PREFIX_MERCHANT;
import static com.lsq.constants.SystemConstants.SYSTEM_SUCCESS_KEY;

@Controller
@RequestMapping("/merchant/apply_user")
public class MerchantApplyJobcontroller {
    @Autowired
    private IApplyUserService applyUserService;
    @Autowired
    private IMessageService messageService;

    @RequestMapping("/select_apply_by_factor")
    @ResponseBody
    public BaseResponse selectApplyByFactor(@RequestBody QueryApplyJob queryApplyJob) {
        return applyUserService.searchApplyUserByFactor(queryApplyJob);
    }

    @RequestMapping("/update_apply")
    @ResponseBody
    public BaseResponse updateApply(@RequestBody ApplyForJob applyForJob) {
        applyForJob.setUpdateTime(new Date());
        SystemResponse result = applyUserService.updateApply(applyForJob);
        if (StringUtils.equals(result.getState(), SYSTEM_SUCCESS_KEY)) {
            MyMessages systemMessage = new MyMessages();
            systemMessage.setType(MESSAGE_TYPE_SYSTEM);
            systemMessage.setState(MESSAGE_STATE_UNREAD);
            systemMessage.setAcceptAccount(applyForJob.getUserAccount());
            systemMessage.setSendAccount(applyForJob.getMerchantAccount());
            systemMessage.setContent("商家" + applyForJob.getUserAccount() + applyForJob.getState() + "你的申请");
            systemMessage.setCreateTime(new Date());
            messageService.add(systemMessage);
            WebSocketServer.sendInfo(systemMessage);
        }
        return result;
    }
}
