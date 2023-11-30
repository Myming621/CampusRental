package com.mym.bus.controller;

import com.mym.bus.service.ICustomerService;
import com.mym.bus.vo.CustomerVo;
import com.mym.sys.utils.DataGridView;
import com.mym.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 客户
 */
@Controller
@RequestMapping("customer")
public class CustomerContoller {

    @Autowired
    private ICustomerService customerService;

    /**
     * 查询客户信息
     */
    @RequestMapping("loadAllCustomer")
    @ResponseBody
    public DataGridView loadAllCustomer(CustomerVo customerVo){return  customerService.queryAllCustomer(customerVo);}

    /**
     * 添加客户
     */
    @RequestMapping("addCustomer")
    @ResponseBody
    public ResultObj addCustomer(CustomerVo customerVo){
        try {
            customerVo.setCreatetime(new Date());
            this.customerService.addCustomer(customerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 删除客户信息
     */
    @RequestMapping("deleteCustomer")
    @ResponseBody
    public ResultObj deleteCustomer(String identity){
        try {
            customerService.deleteCustomer(identity);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 修改客户信息
     */
    @RequestMapping("updateCustomer")
    @ResponseBody
    public ResultObj updateCustomer(CustomerVo customerVo){
        try {
            customerService.updateCustomer(customerVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 批量删除客户信息
     */
    @RequestMapping("deleteBatchCustomer")
    @ResponseBody
    public ResultObj deleteBatchCustomer(CustomerVo customerVo){
        try {
            customerService.deleteBatchCustomer(customerVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
