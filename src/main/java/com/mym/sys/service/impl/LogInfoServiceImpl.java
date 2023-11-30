package com.mym.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mym.sys.domain.LogInfo;
import com.mym.sys.domain.LogInfoVo;
import com.mym.sys.mapper.LogInfoMapper;
import com.mym.sys.service.ILogInfoService;
import com.mym.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogInfoServiceImpl implements ILogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
     * 分页查询日志
     * @param logInfoVo
     * @return
     */
    @Override
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo) {
        Page<LogInfo> page = PageHelper.startPage(logInfoVo.getPage(),logInfoVo.getLimit());
        List<LogInfo> data =  logInfoMapper.queryAllLogInfo(logInfoVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void deleteLogInfo(Integer id) {
        logInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBatchLogInfo(LogInfoVo logInfoVo) {
        for (Integer id : logInfoVo.getIds()) {
            deleteLogInfo(id);
        }
    }
}
