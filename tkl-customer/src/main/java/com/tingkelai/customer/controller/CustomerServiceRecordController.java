package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerServiceRecordApi;
import com.tingkelai.domain.customer.ServiceRecord;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.customer.ServiceRecordVO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户服务记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:20:09
 * @version 1.0
 */
@RestController
public class CustomerServiceRecordController extends BaseCRUDController<ServiceRecord, Long>
        implements CustomerServiceRecordApi<ServiceRecordVO> {

    @Override
    public ResponseMessage<ServiceRecordVO> customerServiceRecordDelete(ServiceRecordVO requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<ServiceRecordVO> customerServiceRecordGet(ServiceRecordVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<ServiceRecordVO>> customerServiceRecordListGet(ServiceRecordVO requestBody, BasePage basePage) {
        return list(requestBody, basePage);
    }

    @Override
    public ResponseMessage<ServiceRecordVO> customerServiceRecordPost(ServiceRecordVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<ServiceRecordVO> customerServiceRecordPut(ServiceRecordVO requestBody) {
        return updateEntity(requestBody);
    }
}
