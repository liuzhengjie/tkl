package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerApi;
import com.tingkelai.domain.customer.Customer;
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
public class CustomerController extends BaseCRUDController<Customer, Long> implements CustomerApi<Customer> {


    private Customer requestBody = newModel();

    @Override
    public ApiResponseMessage<List<Customer>> customerListGet(HttpServletRequest request) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<List<Customer>> customerQueryListGet(HttpServletRequest request) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<Customer> customerDelete(HttpServletRequest request) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<Customer> customerGet(HttpServletRequest request) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<Customer> customerPost(HttpServletRequest request) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<Customer> customerPut(HttpServletRequest request) {
        return updateEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<Customer> customerUpdateDelete(HttpServletRequest request) {
        return null;
    }

    @Override
    public ApiResponseMessage<Customer> customerUpdateGet(HttpServletRequest request) {
        return null;
    }

    @Override
    public ApiResponseMessage<Customer> customerUpdatePost(HttpServletRequest request) {
        return null;
    }

    @Override
    public ApiResponseMessage<Customer> customerUpdatePut(HttpServletRequest request) {
        return null;
    }
}
