package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerServiceRecordApi;
import com.tingkelai.domain.customer.ServiceRecord;

import java.util.List;

/**
 * 客户服务记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:20:09
 * @version 1.0
 */
public class CustomerServiceRecordController extends BaseCRUDController<ServiceRecord, Long>
        implements CustomerServiceRecordApi<ServiceRecord> {

    @Override
    public ResponseMessage<ServiceRecord> customerServiceRecordDelete(ServiceRecord requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<ServiceRecord> customerServiceRecordGet(ServiceRecord requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ResponseMessage<List<ServiceRecord>> customerServiceRecordListGet(ServiceRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<ServiceRecord> customerServiceRecordPost(ServiceRecord requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<ServiceRecord> customerServiceRecordPut(ServiceRecord requestBody) {
        return updateEntity(requestBody);
    }
}
