package com.mym.stat.service;

import com.mym.stat.domain.BaseEntity;

import java.util.List;


public interface IStatService {
    List<BaseEntity> loadCustomerAreaStatList();

    List<Double> loadCompanyYearGradeStatList(String year);

    List<BaseEntity> loadOpernameYearGradeStatList(String year);
}
