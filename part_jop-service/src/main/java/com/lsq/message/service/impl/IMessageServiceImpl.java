package com.lsq.message.service.impl;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.message.bean.Content;
import com.lsq.message.bean.MessagesReturn;
import com.lsq.message.bean.QueryMessageBean;
import com.lsq.message.domain.MyMessages;
import com.lsq.message.repository.IMyMessagesRepository;
import com.lsq.message.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lsq.constants.SystemConstants.SYSTEM_SUCCESS_KEY;

@Service
public class IMessageServiceImpl implements IMessageService {
    @Autowired
    private IMyMessagesRepository myMessagesRepository;
    @Override
    public int deleteById(Long id) {
        return myMessagesRepository.deleteByPrimaryKey(id);
    }

    @Override
    public BaseResponse deleteBySendAccount(String sendAccount) {
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY, myMessagesRepository.deleteBySendAccount(sendAccount));
    }

    @Override
    public int add(MyMessages record) {
        return myMessagesRepository.insertSelective(record);
    }

    @Override
    public MyMessages selectById(Long id) {
        return myMessagesRepository.selectByPrimaryKey(id);
    }

    @Override
    public SystemResponse selectByFactor(QueryMessageBean queryMessageBean) {
        List<MyMessages> messagesList = myMessagesRepository.selectByFactor(queryMessageBean);
        Map<String,ArrayList<Content>> results = new HashMap<>(5);
        for(MyMessages temp : messagesList)
        {
            boolean flag = true;
            for (Map.Entry<String,ArrayList<Content>> entry : results.entrySet()) {
                if(entry.getKey().equals(temp.getSendAccount())){
                    Content content = new Content();
                    content.setText(temp.getContent());
                    content.setFlag("accept");
                    content.setCreateTime(temp.getCreateTime());
                    results.get(temp.getSendAccount()).add(content);
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ArrayList<Content> a = new ArrayList<>();
                Content content = new Content();
                content.setText(temp.getContent());
                content.setFlag("accept");
                content.setCreateTime(temp.getCreateTime());
                a.add(content);
                results.put(temp.getSendAccount(),a);
            }
        }
        return new SystemResponse<Map>(SYSTEM_SUCCESS_KEY,results);
    }

    @Override
    public int updateMessage(MyMessages record) {
        return  myMessagesRepository.updateByPrimaryKeySelective(record);
    }
}
