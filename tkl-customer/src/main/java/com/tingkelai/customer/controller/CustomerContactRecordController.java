package com.tingkelai.customer.controller;

import com.tingkelai.dao.customer.ContactRecordMapper;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerContactRecordApi;
import com.tingkelai.domain.customer.ContactRecord;
import com.tingkelai.service.common.ICommonService;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IContactRecordService;
import com.tingkelai.vo.customer.ContactRecordVO;
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
public class CustomerContactRecordController implements CustomerContactRecordApi<ContactRecordVO>{

    /** 日志 */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IContactRecordService contactRecordService;

    @Override
    public ResponseMessage<ContactRecord> customerContactRecordDelete(ContactRecordVO requestBody) {
        try{
            contactRecordService.removeById(requestBody.toDTO());
            return new ResponseMessage<>(requestBody.toDTO());
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<ContactRecord> customerContactRecordGet(ContactRecordVO requestBody) {
        try{
            ContactRecord contactRecord = requestBody.toDTO();
            contactRecord = contactRecordService.getById(contactRecord.getId());
            return new ResponseMessage<>(contactRecord);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<List<ContactRecord>> customerContactRecordListGet(ContactRecordVO requestBody) {
        try{
            List<ContactRecord> list = contactRecordService.list();
            return new ResponseMessage<>(list);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<ContactRecord> customerContactRecordPost(ContactRecordVO requestBody) {
        try{
            ContactRecord contactRecord = requestBody.toDTO();
            contactRecordService.save(contactRecord);
            return new ResponseMessage<>(contactRecord);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<ContactRecord> customerContactRecordPut(ContactRecordVO requestBody) {
        try{
            ContactRecord contactRecord = requestBody.toDTO();
            contactRecordService.saveOrUpdate(contactRecord);
            return new ResponseMessage<>(contactRecord);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }
}
