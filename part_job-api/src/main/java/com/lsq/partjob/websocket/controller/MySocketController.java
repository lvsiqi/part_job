package com.lsq.partjob.websocket.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.message.domain.MyMessages;
import com.lsq.message.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

import static com.lsq.constants.Message.MESSAGE_STATE_UNREAD;

@Controller
@RequestMapping("/MySocketController")
public class MySocketController {
    @Autowired
    private IMessageService messageService;

    @RequestMapping("/publish")
    @ResponseBody
    public void publish(@RequestBody MyMessages myMessages) {
        myMessages.setCreateTime(new Date());
        myMessages.setState(MESSAGE_STATE_UNREAD);
        WebSocketServer.sendInfo(myMessages);
        messageService.add(myMessages);
    }
}
