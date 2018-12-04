package com.tingkelai.customer.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.customer.CustomerFilesApi;
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
    public ResponseMessage customerFilesDelete(Object requestBody) {
        return null;
    }

    @Override
    public ResponseMessage customerFilesGet(Object requestBody) {
        return null;
    }

    @Override
    public ResponseMessage customerFilesListGet(Object requestBody) {
        return null;
    }

    @Override
    public ResponseMessage customerFilesPost(Object requestBody) {
        return null;
    }

    @Override
    public ResponseMessage customerFilesPut(Object requestBody) {
        return null;
    }
}
