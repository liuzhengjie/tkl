package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.customer.CustomerSettingApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * 常用设置处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:21:03
 * @version 1.0
 */
@RestController
public class CustomerSettingController  implements CustomerSettingApi {

    @Override
    public ResponseMessage customerSettingListGet(Object requestBody) {
        return null;
    }

    @Override
    public ResponseMessage customerSettingPut(Object requestBody) {
        return null;
    }
}
