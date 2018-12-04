package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerServiceRecordApi;
import com.tingkelai.domain.customer.ServiceRecord;
import com.tingkelai.vo.customer.ServiceRecordVO;

import java.util.List;

/**
 * 客户服务记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:20:09
 * @version 1.0
 */
public class CustomerServiceRecordController extends BaseCRUDController<ServiceRecord, Long>
        implements CustomerServiceRecordApi<ServiceRecordVO> {

    @Override
    public ResponseMessage<ServiceRecord> customerServiceRecordDelete(ServiceRecordVO requestBody) {
        return deleteEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<ServiceRecord> customerServiceRecordGet(ServiceRecordVO requestBody) {
        return getEntityById(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<List<ServiceRecord>> customerServiceRecordListGet(ServiceRecordVO requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<ServiceRecord> customerServiceRecordPost(ServiceRecordVO requestBody) {
        return saveEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<ServiceRecord> customerServiceRecordPut(ServiceRecordVO requestBody) {
        return updateEntity(requestBody.toDTO());
    }
}
