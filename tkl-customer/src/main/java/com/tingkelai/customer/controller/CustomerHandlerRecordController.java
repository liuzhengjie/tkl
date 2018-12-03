package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerHandlerRecordApi;
import com.tingkelai.domain.customer.HandlerRecord;
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
    public ResponseMessage<HandlerRecord> customerHandlerRecordDelete(HandlerRecord requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<HandlerRecord> customerHandlerRecordGet(HandlerRecord requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ResponseMessage<List<HandlerRecord>> customerHandlerRecordListGet(HandlerRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<HandlerRecord> customerHandlerRecordPost(HandlerRecord requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<HandlerRecord> customerHandlerRecordPut(HandlerRecord requestBody) {
        return updateEntity(requestBody);
    }
}
