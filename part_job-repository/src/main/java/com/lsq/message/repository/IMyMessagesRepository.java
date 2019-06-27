package com.lsq.message.repository;

import com.lsq.message.bean.QueryMessageBean;
import com.lsq.message.domain.MyMessages;

import java.util.List;

public interface IMyMessagesRepository {
    int deleteByPrimaryKey(Long id);

    int deleteBySendAccount(String sendAccount);

    int insertSelective(MyMessages record);

    MyMessages selectByPrimaryKey(Long id);

    List<MyMessages> selectByFactor(QueryMessageBean queryMessageBean);

    int updateByPrimaryKeySelective(MyMessages record);
}
