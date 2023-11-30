package com.mym.sys.service.impl;

import com.mym.sys.mapper.AccountMapper;
import com.mym.sys.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional  //事务控制
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     *
     * @param inName
     * @param outName
     * @param money
     * @return
     */
    public int updateTransfer(String inName, String outName, double money) {

        //调用转入操作
        accountMapper.transferIn(inName,money);

        //调用转出操作
        accountMapper.transferOut(outName,money);
        return 1;
    }
}
