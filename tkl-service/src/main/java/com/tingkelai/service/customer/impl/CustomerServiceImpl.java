package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.CustomerMapper;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl extends CommonServiceImpl<Customer> implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public IPage<Customer> page(IPage<Customer> iPage, Wrapper<Customer> wrapper) {
        try {
            //设置查询条件
            Customer product = wrapper.getEntity();
            QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
            //产品名非空，则模糊查询
            if(product.getName() != null){
                queryWrapper.like("name", product.getName());
            }
            //产品code非空，则模糊查询
            if(product.getCode() != null){
                queryWrapper.like("code", product.getCode());
            }

            //获取查询结果
            IPage<Customer> productTypeIPage = customerMapper.page(iPage, queryWrapper);
            //加工返回值
            return productTypeIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Customer getOne(Wrapper<Customer> wrapper) {
        Customer customer = wrapper.getEntity();
        if(customer.getId() != null){
            return customerMapper.getById(customer.getId());
        }
        return super.getOne(wrapper);
    }

    @Override
    public boolean remove(Wrapper<Customer> wrapper) {
        Customer customer = wrapper.getEntity();
        Long id = customer.getId();
        if(id != null){
            return super.removeById(id);
        }
        return super.removeById(id);
    }
}
