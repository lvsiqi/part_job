package com.lsq.partjob.message.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.message.bean.QueryMessageBean;
import com.lsq.message.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/5/16 16:13
 
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private IMessageService messageService;
    @RequestMapping("/get_message_by_factor")
    @ResponseBody
    public BaseResponse getUnreadMessage(@RequestBody QueryMessageBean queryMessageBean){
        return messageService.selectByFactor(queryMessageBean);
    }

    @RequestMapping("/delete_message_by_send_account")
    @ResponseBody
    public BaseResponse deleteMessageBySendAccount(@RequestBody QueryMessageBean queryMessageBean){
        return messageService.deleteBySendAccount(queryMessageBean.getSendAccount());
    }
}
