package com.mym.stat.mapper;

import com.mym.stat.domain.BaseEntity;

import java.util.List;


public interface StatMapper {
    List<BaseEntity> queryCustomerAreaStat();

    List<Double> queryCompanyYearGradeStat(String year);

    List<BaseEntity> queryOpernameYearGradeStat(String year);
}
