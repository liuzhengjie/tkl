package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerHandlerRecordApi;
import com.tingkelai.domain.customer.HandlerRecord;
import com.tingkelai.vo.customer.HandlerRecordVO;
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
public class CustomerHandlerRecordController extends BaseCRUDController<HandlerRecord, Long> implements CustomerHandlerRecordApi<HandlerRecordVO> {

    @Override
    public ResponseMessage<HandlerRecord> customerHandlerRecordDelete(HandlerRecordVO requestBody) {
        return deleteEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<HandlerRecord> customerHandlerRecordGet(HandlerRecordVO requestBody) {
        return getEntityById(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<List<HandlerRecord>> customerHandlerRecordListGet(HandlerRecordVO requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<HandlerRecord> customerHandlerRecordPost(HandlerRecordVO requestBody) {
        return saveEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<HandlerRecord> customerHandlerRecordPut(HandlerRecordVO requestBody) {
        return updateEntity(requestBody.toDTO());
    }
}
