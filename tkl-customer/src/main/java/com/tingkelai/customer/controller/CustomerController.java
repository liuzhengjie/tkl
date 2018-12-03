package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerApi;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.service.customer.ICustomerService;
import com.tingkelai.shiro.util.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 客户管理模块，客户主类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:09:48
 * @version 1.0
 */
@RestController
@RequiresPermissions("sys:menu:custom")
public class CustomerController extends BaseCRUDController<Customer, Long> implements CustomerApi<Customer> {

    private Customer requestBody = newModel();

    @Override
    public ResponseMessage<List<Customer>> customerListGet(HttpServletRequest request) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<List<Customer>> customerQueryListGet(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseMessage<Customer> customerDelete(HttpServletRequest request) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<Customer> customerGet(HttpServletRequest request) {
        return getEntityById(requestBody);
    }

    @Override
    public ResponseMessage<Customer> customerPost(HttpServletRequest request) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<Customer> customerPut(HttpServletRequest request) {
        return updateEntity(requestBody);
    }

    @Override
    public ResponseMessage<Customer> customerUpdateDelete(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseMessage<Customer> customerUpdateGet(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseMessage<Customer> customerUpdatePost(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseMessage<Customer> customerUpdatePut(HttpServletRequest request) {
        return null;
    }
}
