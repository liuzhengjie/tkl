package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerHandlerRecordApi;
import com.tingkelai.domain.customer.HandlerRecord;
import com.tingkelai.service.customer.IHandlerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户经手人变更记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:15:09
 * @version 1.0
 */
@RestController
public class CustomerHandlerRecordController extends BaseCRUDController<HandlerRecord, Long> implements CustomerHandlerRecordApi<HandlerRecord> {



    @Override
    public ApiResponseMessage<HandlerRecord> customerHandlerRecordDelete(HandlerRecord requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<HandlerRecord> customerHandlerRecordGet(HandlerRecord requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<List<HandlerRecord>> customerHandlerRecordListGet(HandlerRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<HandlerRecord> customerHandlerRecordPost(HandlerRecord requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<HandlerRecord> customerHandlerRecordPut(HandlerRecord requestBody) {
        return updateEntity(requestBody);
    }
}
