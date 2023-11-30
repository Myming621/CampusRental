package com.mym.stat.service.impl;

import com.mym.stat.domain.BaseEntity;
import com.mym.stat.mapper.StatMapper;
import com.mym.stat.service.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatService implements IStatService {

    @Autowired
    private StatMapper statMapper;

    @Override
    public List<BaseEntity> loadCustomerAreaStatList() {
        return statMapper.queryCustomerAreaStat();
    }

    @Override
    public List<Double> loadCompanyYearGradeStatList(String year) {
        return statMapper.queryCompanyYearGradeStat(year);
    }

    @Override
    public List<BaseEntity> loadOpernameYearGradeStatList(String year) {
        return statMapper.queryOpernameYearGradeStat(year);
    }
}
