package com.mym.bus.service;

import com.mym.bus.domain.Rent;
import com.mym.bus.vo.RentVo;
import com.mym.sys.utils.DataGridView;

/**
 * 租单逻辑层
 */
public interface IRentService {
    void addRent(RentVo rentVo);

    DataGridView queryAllRent(RentVo rentVo);

    void updateRent(RentVo rentVo);

    void deleteRent(RentVo rentVo);

    Rent queryRentByRentId(String rentid);
}
