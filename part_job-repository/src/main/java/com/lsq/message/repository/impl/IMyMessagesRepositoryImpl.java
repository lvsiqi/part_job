package com.lsq.message.repository.impl;

import com.lsq.message.bean.QueryMessageBean;
import com.lsq.message.domain.MyMessages;
import com.lsq.message.repository.IMyMessagesRepository;
import com.lsq.message.repository.mapper.MyMessagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IMyMessagesRepositoryImpl implements IMyMessagesRepository {
    @Autowired
    private MyMessagesMapper myMessagesMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return myMessagesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBySendAccount(String sendAccount) {
        return myMessagesMapper.deleteBySendAccount(sendAccount);
    }

    @Override
    public int insertSelective(MyMessages record) {
        return myMessagesMapper.insertSelective(record);
    }

    @Override
    public MyMessages selectByPrimaryKey(Long id) {
        return myMessagesMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MyMessages> selectByFactor(QueryMessageBean queryMessageBean) {
        return myMessagesMapper.selectByFactor(queryMessageBean);
    }

    @Override
    public int updateByPrimaryKeySelective(MyMessages record) {
        return myMessagesMapper.updateByPrimaryKeySelective(record);
    }
}
