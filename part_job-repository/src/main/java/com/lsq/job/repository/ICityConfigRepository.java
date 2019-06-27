package com.lsq.job.repository;

import com.lsq.job.domain.CityConfig;

import java.util.List;

public interface ICityConfigRepository {
    List<CityConfig> selectAll();
}
