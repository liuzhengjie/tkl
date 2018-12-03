package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerLinkManApi;
import com.tingkelai.domain.customer.LinkMan;
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
    public ResponseMessage<LinkMan> customerLinkmanDelete(LinkMan requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<LinkMan> customerLinkmanGet(LinkMan requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ResponseMessage<List<LinkMan>> customerLinkmanListGet(LinkMan requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<LinkMan> customerLinkmanPost(LinkMan requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<LinkMan> customerLinkmanPut(LinkMan requestBody) {
        return updateEntity(requestBody);
    }
}
