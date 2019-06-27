package com.lsq.message.service;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.message.bean.QueryMessageBean;
import com.lsq.message.domain.MyMessages;

import java.util.List;

public interface IMessageService {
    int deleteById(Long id);

    BaseResponse deleteBySendAccount(String sendAccount);

    int add(MyMessages record);

    MyMessages selectById(Long id);

    SystemResponse selectByFactor(QueryMessageBean queryMessageBean);

    int updateMessage(MyMessages record);
}
