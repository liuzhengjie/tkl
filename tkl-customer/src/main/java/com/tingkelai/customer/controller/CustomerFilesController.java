package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerFilesApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户文件资料处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:12:53
 * @version 1.0
 */
@RestController
public class CustomerFilesController implements CustomerFilesApi {

    @Override
    public ApiResponseMessage customerFilesDelete(Object requestBody) {
        return null;
    }

    @Override
    public ApiResponseMessage customerFilesGet(Object requestBody) {
        return null;
    }

    @Override
    public ApiResponseMessage customerFilesListGet(Object requestBody) {
        return null;
    }

    @Override
    public ApiResponseMessage customerFilesPost(Object requestBody) {
        return null;
    }

    @Override
    public ApiResponseMessage customerFilesPut(Object requestBody) {
        return null;
    }
}
