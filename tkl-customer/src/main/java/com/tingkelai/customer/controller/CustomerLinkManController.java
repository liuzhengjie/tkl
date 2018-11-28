package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerLinkManApi;
import com.tingkelai.domain.customer.LinkMan;
import com.tingkelai.service.customer.ILinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户联系人处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:16:14
 * @version 1.0
 */
@RestController
public class CustomerLinkManController extends BaseCRUDController<LinkMan, Long> implements CustomerLinkManApi<LinkMan> {

    @Override
    public ApiResponseMessage<LinkMan> customerLinkmanDelete(LinkMan requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<LinkMan> customerLinkmanGet(LinkMan requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<List<LinkMan>> customerLinkmanListGet(LinkMan requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<LinkMan> customerLinkmanPost(LinkMan requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<LinkMan> customerLinkmanPut(LinkMan requestBody) {
        return updateEntity(requestBody);
    }
}
