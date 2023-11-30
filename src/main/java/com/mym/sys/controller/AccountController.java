package com.mym.sys.controller;

import com.mym.sys.service.IAccountService;
import com.mym.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("transfer")
    @ResponseBody
    @Transactional
    public ResultObj accountTransfer(String inName,String outName,double money){
        int status = accountService.updateTransfer(inName,outName,money);
        if (status > 0){
            //转账成功
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }
}
