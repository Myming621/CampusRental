package com.mym.bus.mapper;

import com.mym.bus.domain.Rent;
import com.mym.bus.vo.RentVo;

import java.util.List;


public interface RentMapper {
    void insertSelective(RentVo rentVo);

    List<Rent> queryAllRent(RentVo rentVo);

    void updateByPrimaryKeySelective(RentVo rentVo);

    void deleteByPrimaryKey(String rentid);

    Rent queryRentById(String rentid);
}
