package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerLinkManApi;
import com.tingkelai.domain.customer.LinkMan;
import com.tingkelai.vo.customer.LinkManVO;
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
public class CustomerLinkManController extends BaseCRUDController<LinkMan, Long> implements CustomerLinkManApi<LinkManVO> {

    @Override
    public ResponseMessage<LinkMan> customerLinkmanDelete(LinkManVO requestBody) {
        return deleteEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<LinkMan> customerLinkmanGet(LinkManVO requestBody) {
        return getEntityById(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<List<LinkMan>> customerLinkmanListGet(LinkManVO requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<LinkMan> customerLinkmanPost(LinkManVO requestBody) {
        return saveEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<LinkMan> customerLinkmanPut(LinkManVO requestBody) {
        return updateEntity(requestBody.toDTO());
    }
}
