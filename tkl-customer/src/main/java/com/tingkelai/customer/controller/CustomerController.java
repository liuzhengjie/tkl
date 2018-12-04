package com.tingkelai.customer.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.service.customer.impl.CustomerServiceImpl;
import com.tingkelai.vo.customer.CustomerVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 客户管理模块，客户主类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:09:48
 * @version 1.0
 */
@RestController
@RequiresPermissions("sys:menu:custom")
public class CustomerController extends BaseCRUDController<Customer, Long> implements CustomerApi<CustomerVO> {

    @Autowired
    private CustomerServiceImpl customerService;

    @Override
    public ResponseMessage<List<CustomerVO>> customerListGet(CustomerVO customerVO) {
        return getEntityList(customerVO);
    }

    @Override
    public ResponseMessage<CustomerVO> customerDelete(CustomerVO customerVO) {
        return deleteEntity(customerVO);
    }

    @Override
    public ResponseMessage<CustomerVO> customerGet(CustomerVO customerVO) {
        return getEntity(customerVO);
    }

    @Override
    public ResponseMessage<CustomerVO> customerPost(CustomerVO customerVO) {
        return saveEntity(customerVO);
    }

    @Override
    public ResponseMessage<CustomerVO> customerPut(CustomerVO customerVO) {
        return updateEntity(customerVO);
    }

    @Override
    public ResponseMessage customerQueryListGet(CustomerVO customerVO) {
        return getEntityList(customerVO);
    }

    @Override
    public ResponseMessage customerUpdateDelete(CustomerVO customerVO) {
        return null;
    }

    @Override
    public ResponseMessage customerUpdateGet(CustomerVO customerVO) {
        return null;
    }

    @Override
    public ResponseMessage customerUpdatePost(CustomerVO customerVO) {
        return null;
    }

    @Override
    public ResponseMessage customerUpdatePut(CustomerVO customerVO) {
        return null;
    }
}
