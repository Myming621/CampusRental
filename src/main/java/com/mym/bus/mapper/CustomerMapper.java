package com.mym.bus.mapper;

import com.mym.bus.domain.Customer;
import com.mym.bus.vo.CustomerVo;

import java.util.List;


public interface CustomerMapper {
    List<Customer> queryAllCustomer(CustomerVo customerVo);

    void insertSelective(CustomerVo customerVo);

    void deleteCustomer(String identity);

    void updateCustomer(CustomerVo customerVo);

    Customer selectByPrimaryKey(String identity);
}
