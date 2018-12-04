package com.tingkelai.customer.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerContactRecordApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.customer.ContactRecord;
import com.tingkelai.service.customer.IContactRecordService;
import com.tingkelai.vo.customer.ContactRecordVO;
import io.swagger.models.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomerContactRecordController extends BaseCRUDController<ContactRecord, Long> implements CustomerContactRecordApi<ContactRecordVO>{

    /** 日志 */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ResponseMessage<ContactRecordVO> customerContactRecordDelete(ContactRecordVO requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<ContactRecordVO> customerContactRecordGet(ContactRecordVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<ContactRecordVO>> customerContactRecordListGet(ContactRecordVO requestBody) {
        return getEntityList(requestBody);
    }

    @Override
    public ResponseMessage<ContactRecordVO> customerContactRecordPost(ContactRecordVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<ContactRecordVO> customerContactRecordPut(ContactRecordVO requestBody) {
        return updateEntity(requestBody);
    }
}
