package com.mym.bus.mapper;

import com.mym.bus.domain.Car;
import com.mym.bus.vo.CarVo;

import java.util.List;


public interface CarMapper {
    List<Car> queryAllCar(CarVo carVo);

    void insertSelective(CarVo carVo);

    Car selectByPrimaryKey(String carnumber);

    void deleteByPrimaryKey(String carnumber);

    void updateByPrimaryKeySelective(CarVo carVo);
}
