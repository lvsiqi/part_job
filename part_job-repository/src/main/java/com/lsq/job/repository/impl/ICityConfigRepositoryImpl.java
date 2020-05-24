package com.lsq.job.repository.impl;

import com.lsq.job.domain.CityConfig;
import com.lsq.job.repository.ICityConfigRepository;
import com.lsq.job.repository.mapper.CityConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ICityConfigRepositoryImpl implements ICityConfigRepository {
    @Autowired
    CityConfigMapper cityConfigMapper;

    @Override
    public List<CityConfig> selectAll() {
        return cityConfigMapper.selectAll();
    }
}
