package com.tingkelai.customer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerLinkManApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.customer.LinkMan;
import com.tingkelai.vo.BasePage;
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
    public ResponseMessage<LinkManVO> customerLinkmanDelete(LinkManVO requestBody) {
        QueryWrapper<LinkMan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", requestBody.getId());
        return removeEntity(requestBody, queryWrapper);
    }

    @Override
    public ResponseMessage<LinkManVO> customerLinkmanGet(LinkManVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<LinkManVO>> customerLinkmanListGet(LinkManVO requestBody, BasePage basePage) {
        return list(requestBody, basePage);
    }

    @Override
    public ResponseMessage<LinkManVO> customerLinkmanPost(LinkManVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<LinkManVO> customerLinkmanPut(LinkManVO requestBody) {
        return updateEntity(requestBody);
    }
}
