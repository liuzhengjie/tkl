package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerFollowRecordApi;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.service.customer.IFollowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ApiResponseMessage<FollowRecord> customerFollowRecordDelete(FollowRecord requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<FollowRecord> customerFollowRecordGet(FollowRecord requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<List<FollowRecord>> customerFollowRecordListGet(FollowRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<FollowRecord> customerFollowRecordPost(FollowRecord requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<FollowRecord> customerFollowRecordPut(FollowRecord requestBody) {
        return updateEntity(requestBody);
    }
}
