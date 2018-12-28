package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerFollowRecordApi;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.customer.FollowRecordVO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户跟进记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:14:02
 * @version 1.0
 */
@RestController
public class CustomerFollowRecordController  extends BaseCRUDController<FollowRecord, Long> implements CustomerFollowRecordApi<FollowRecordVO> {

    @Override
    public ResponseMessage<FollowRecordVO> customerFollowRecordDelete(FollowRecordVO requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<FollowRecordVO> customerFollowRecordGet(FollowRecordVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage customerFollowRecordListGet(FollowRecordVO requestBody, BasePage basePage) {
        return list(requestBody, basePage);
    }

    @Override
    public ResponseMessage<FollowRecordVO> customerFollowRecordPost(FollowRecordVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<FollowRecordVO> customerFollowRecordPut(FollowRecordVO requestBody) {
        return updateEntity(requestBody);
    }
}
