package com.mym.sys.service;

import com.mym.sys.domain.LogInfoVo;
import com.mym.sys.utils.DataGridView;


public interface ILogInfoService {
    DataGridView queryAllLogInfo(LogInfoVo logInfoVo);

    void deleteLogInfo(Integer id);

    void deleteBatchLogInfo(LogInfoVo logInfoVo);
}
