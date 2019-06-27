package com.lsq.job.repository.impl;

import com.lsq.job.bean.QueryPageBean;
import com.lsq.job.domain.PartTimeJob;
import com.lsq.job.repository.IPartTimeJobRepository;
import com.lsq.job.repository.mapper.PartTimeJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IPartTimeJobRepositoryImpl implements IPartTimeJobRepository {
    @Autowired
    private PartTimeJobMapper partTimeJobMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return partTimeJobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PartTimeJob record) {
        return partTimeJobMapper.insert(record);
    }

    @Override
    public int insertSelective(PartTimeJob record) {
        return partTimeJobMapper.insertSelective(record);
    }

    @Override
    public PartTimeJob selectByPrimaryKey(Long id) {
        return partTimeJobMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PartTimeJob> selectPageByAccount(QueryPageBean queryPageBean) {
        return partTimeJobMapper.selectPageByAccount(queryPageBean);
    }

    @Override
    public int selectCountByAccount (String account){
        return partTimeJobMapper.selectCountByAccount(account);
    }

    @Override
    public int updateByPrimaryKeySelective(PartTimeJob record) {
        return partTimeJobMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PartTimeJob record) {
        return partTimeJobMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PartTimeJob> selectPageByName(QueryPageBean queryPageBean) {
        return partTimeJobMapper.selectPageByName(queryPageBean);
    }

    @Override
    public int selectCountByName(String jobName) {
        return partTimeJobMapper.selectCountByName(jobName);
    }

    @Override
    public List<PartTimeJob> selectPageAll(QueryPageBean queryPageBean) {
        return partTimeJobMapper.selectPageAll(queryPageBean);
    }

    @Override
    public int selectCountAll() {
        return partTimeJobMapper.selectCountAll();
    }

    @Override
    public List<PartTimeJob> selectPageByFactor(QueryPageBean queryPageBean) {
        return partTimeJobMapper.selectPageByFactor(queryPageBean);
    }

    @Override
    public int selectCountByFactor(QueryPageBean queryPageBean) {
        return partTimeJobMapper.selectCountByFactor(queryPageBean);
    }
}
