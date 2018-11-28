package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.CustomerMapper;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ICustomerService;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl extends CommonServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
