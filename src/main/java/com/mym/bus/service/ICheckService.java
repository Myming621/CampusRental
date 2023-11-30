package com.mym.bus.service;

import com.mym.bus.vo.CheckVo;
import com.mym.sys.utils.DataGridView;

import java.util.Map;

/**
 * 检查单逻辑层
 */
public interface ICheckService {

    Map<String,Object> initCheckFormData(String rentid);

    void addCheck(CheckVo checkVo);

    DataGridView queryAllCheck(CheckVo checkVo);

    void updateCheck(CheckVo checkVo);

    void deleteCheck(String checkid);

    void deleteBatchCheck(String[] ids);
}
