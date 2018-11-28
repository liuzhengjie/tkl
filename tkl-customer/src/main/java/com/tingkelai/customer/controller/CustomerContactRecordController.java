package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerContactRecordApi;
import com.tingkelai.domain.customer.ContactRecord;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户联系记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:11:08
 * @version 1.0
 */
@RestController
public class CustomerContactRecordController extends BaseCRUDController<ContactRecord, Long> implements CustomerContactRecordApi<ContactRecord>{

    @Override
    public ApiResponseMessage<ContactRecord> customerContactRecordDelete(ContactRecord contactRecord) {
        return deleteEntity(contactRecord);
    }

    @Override
    public ApiResponseMessage<ContactRecord> customerContactRecordGet(ContactRecord contactRecord) {
        return getEntityById(contactRecord);
    }

    @Override
    public ApiResponseMessage<List<ContactRecord>> customerContactRecordListGet(ContactRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<ContactRecord> customerContactRecordPost(ContactRecord contactRecord) {
        return saveEntity(contactRecord);
    }

    @Override
    public ApiResponseMessage<ContactRecord> customerContactRecordPut(ContactRecord contactRecord) {
        return updateEntity(contactRecord);
    }
}
