package com.lsq.job.repository.mapper;

import com.lsq.job.bean.QueryPageBean;
import com.lsq.job.domain.PartTimeJob;

import java.util.List;

public interface PartTimeJobMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PartTimeJob record);

    int insertSelective(PartTimeJob record);

    PartTimeJob selectByPrimaryKey(Long id);

    List<PartTimeJob> selectPageByAccount(QueryPageBean queryPageBean);

    int selectCountByAccount (String account);

    int updateByPrimaryKeySelective(PartTimeJob record);

    int updateByPrimaryKey(PartTimeJob record);

    List<PartTimeJob> selectPageByName(QueryPageBean queryPageBean);

    int selectCountByName (String jobName);

    List<PartTimeJob> selectPageAll(QueryPageBean queryPageBean);

    int selectCountAll();

    List<PartTimeJob> selectPageByFactor(QueryPageBean queryPageBean);

    int selectCountByFactor(QueryPageBean queryPageBean);
}