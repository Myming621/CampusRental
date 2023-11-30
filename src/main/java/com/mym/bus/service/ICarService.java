package com.mym.bus.service;

import com.mym.bus.domain.Car;
import com.mym.bus.vo.CarVo;
import com.mym.sys.utils.DataGridView;

/**
 * 车辆逻辑层
 */
public interface ICarService {
    DataGridView queryAllCar(CarVo carVo);

    void addCar(CarVo carVo);

    void deleteCar(String carnumber);

    Car queryCarByCarNumber(String carnumber);

    void updateCar(CarVo carVo);

    void deleteBatchCar(String[] ids);
}
