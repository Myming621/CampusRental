package com.mym.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mym.bus.domain.Car;
import com.mym.bus.domain.Rent;
import com.mym.bus.mapper.CarMapper;
import com.mym.bus.mapper.RentMapper;
import com.mym.bus.service.IRentService;
import com.mym.bus.vo.CarVo;
import com.mym.bus.vo.RentVo;
import com.mym.sys.constant.SysConstant;
import com.mym.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements IRentService {

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public void addRent(RentVo rentVo) {
        this.rentMapper.insertSelective(rentVo);
        //更改车辆的出租信息
        CarVo vo  = new CarVo();
        vo.setCarnumber(rentVo.getCarnumber());
        //设置车辆的状态为已出租
        vo.setIsrenting(SysConstant.RENT_BACK_TRUE);
        carMapper.updateByPrimaryKeySelective(vo);
    }

    /**
     * 分页查询出租单
     * @param rentVo
     * @return
     */
    @Override
    public DataGridView queryAllRent(RentVo rentVo) {
        Page<Rent> page = PageHelper.startPage(rentVo.getPage(),rentVo.getLimit());
        //做全查询
        List<Rent> data = rentMapper.queryAllRent(rentVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void updateRent(RentVo rentVo) {
        rentMapper.updateByPrimaryKeySelective(rentVo);
    }

    @Override
    public void deleteRent(RentVo rentVo) {
        CarVo carvo = new CarVo();
        carvo.setCarnumber(rentVo.getCarnumber());
        carvo.setIsrenting(SysConstant.RENT_CAR_FALSE); //车辆为出租状态
        //删除出租单
        rentMapper.deleteByPrimaryKey(rentVo.getRentid());
        //更新车辆的状态
        carMapper.updateByPrimaryKeySelective(carvo);
    }

    @Override
    public Rent queryRentByRentId(String rentid) {
        return   rentMapper.queryRentById(rentid);
    }

}
