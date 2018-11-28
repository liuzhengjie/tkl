package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerServiceRecordApi;
import com.tingkelai.domain.customer.ServiceRecord;
import com.tingkelai.service.customer.IServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
    public ApiResponseMessage<ServiceRecord> customerServiceRecordDelete(ServiceRecord requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<ServiceRecord> customerServiceRecordGet(ServiceRecord requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<List<ServiceRecord>> customerServiceRecordListGet(ServiceRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<ServiceRecord> customerServiceRecordPost(ServiceRecord requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<ServiceRecord> customerServiceRecordPut(ServiceRecord requestBody) {
        return updateEntity(requestBody);
    }
}
