package com.mym.bus.mapper;

import com.mym.bus.domain.Check;
import com.mym.bus.vo.CheckVo;

import java.util.List;


public interface CheckMapper {
    /**
     * 添加检查单
     * @param checkVo
     */
    void insertSelective(CheckVo checkVo);

    /**
     * 查询所有的检查单
     * @param checkVo
     * @return
     */
    List<Check> queryAllCheck(CheckVo checkVo);

    void updateByPrimaryKeySelective(CheckVo checkVo);

    void deleteByPrimaryKey(String checkid);
}
