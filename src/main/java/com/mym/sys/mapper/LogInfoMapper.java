package com.mym.sys.mapper;

import com.mym.sys.domain.LogInfo;
import com.mym.sys.domain.LogInfoVo;

import java.util.List;


public interface LogInfoMapper {
    List<LogInfo> queryAllLogInfo(LogInfoVo logInfoVo);

    void deleteByPrimaryKey(Integer id);
}
