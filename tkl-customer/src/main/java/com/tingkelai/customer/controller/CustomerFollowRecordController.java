package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerFollowRecordApi;
import com.tingkelai.domain.customer.FollowRecord;
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
public class CustomerFollowRecordController  extends BaseCRUDController<FollowRecord, Long> implements CustomerFollowRecordApi<FollowRecord> {

    @Override
    public ResponseMessage<FollowRecord> customerFollowRecordDelete(FollowRecord requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<FollowRecord> customerFollowRecordGet(FollowRecord requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ResponseMessage<List<FollowRecord>> customerFollowRecordListGet(FollowRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<FollowRecord> customerFollowRecordPost(FollowRecord requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<FollowRecord> customerFollowRecordPut(FollowRecord requestBody) {
        return updateEntity(requestBody);
    }
}
