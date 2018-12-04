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
public class CustomerController extends BaseCRUDController<Customer, Long> implements CustomerApi {

    @Autowired
    private CustomerServiceImpl customerService;

    @Override
    public ResponseMessage customerListGet() {
        return null;
    }

    @Override
    public ResponseMessage customerQueryListGet() {
        return null;
    }

    @Override
    public ResponseMessage customerDelete() {
        return null;
    }

    @Override
    public ResponseMessage customerGet() {
        return null;
    }

    @Override
    public ResponseMessage customerPost() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.success("权限设置成功");
        try {
            //请求参数中必须有method = customerPost，否则不予处理
            if(getParameter(METHOD).equals("customerPost")){

            }else{
                responseMessage.fail("缺少请求参数");
            }
        } catch (Exception e) {
            responseMessage.fail("权限设置失败");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage customerPut() {
        return null;
    }

    @Override
    public ResponseMessage customerUpdateDelete() {
        return null;
    }

    @Override
    public ResponseMessage customerUpdateGet() {
        return null;
    }

    @Override
    public ResponseMessage customerUpdatePost() {
        return null;
    }

    @Override
    public ResponseMessage customerUpdatePut() {
        return null;
    }
}
