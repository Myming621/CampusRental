package com.mym.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mym.bus.domain.Customer;
import com.mym.bus.mapper.CustomerMapper;
import com.mym.bus.service.ICustomerService;
import com.mym.bus.vo.CustomerVo;
import com.mym.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 分页查询客户信息
     * @param customerVo
     * @return
     */
    @Override
    public DataGridView queryAllCustomer(CustomerVo customerVo) {
        Page<Object> page =   PageHelper.startPage(customerVo.getPage(),customerVo.getLimit());
        List<Customer> data = customerMapper.queryAllCustomer(customerVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加客户信息
     * @param customerVo
     */
    @Override
    public void addCustomer(CustomerVo customerVo) {
        customerMapper.insertSelective(customerVo);
    }

    @Override
    public void deleteCustomer(String identity) {
        customerMapper.deleteCustomer(identity);
    }

    @Override
    public void updateCustomer(CustomerVo customerVo) {
        customerMapper.updateCustomer(customerVo);
    }

    @Override
    public void deleteBatchCustomer(String[] ids) {
        for (String identity : ids){
            this.deleteCustomer(identity);
        }
    }

    @Override
    public Customer queryCustomerByIdentity(String identity) {
        return customerMapper.selectByPrimaryKey(identity);
    }
}
