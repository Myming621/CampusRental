package com.mym.bus.service;

import com.mym.bus.domain.Customer;
import com.mym.bus.vo.CustomerVo;
import com.mym.sys.utils.DataGridView;

/**
 * 客户逻辑层
 */
public interface ICustomerService {
    public DataGridView queryAllCustomer(CustomerVo customerVo);

    void addCustomer(CustomerVo customerVo);

    void deleteCustomer(String identity);

    void updateCustomer(CustomerVo customerVo);

    void deleteBatchCustomer(String[] ids);

    Customer queryCustomerByIdentity(String identity);
}
