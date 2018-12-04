package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerFollowRecordApi;
import com.tingkelai.domain.customer.FollowRecord;
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
    public ResponseMessage<FollowRecord> customerFollowRecordDelete(FollowRecordVO requestBody) {
        FollowRecord followRecord = requestBody.toDTO();
        return deleteEntity(followRecord);
    }

    @Override
    public ResponseMessage<FollowRecord> customerFollowRecordGet(FollowRecordVO requestBody) {
        FollowRecord followRecord = requestBody.toDTO();
        return getEntityById(followRecord);
    }

    @Override
    public ResponseMessage customerFollowRecordListGet(FollowRecordVO requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<FollowRecord> customerFollowRecordPost(FollowRecordVO requestBody) {
        FollowRecord followRecord = requestBody.toDTO();
        return saveEntity(followRecord);
    }

    @Override
    public ResponseMessage<FollowRecord> customerFollowRecordPut(FollowRecordVO requestBody) {
        FollowRecord followRecord = requestBody.toDTO();
        return updateEntity(followRecord);
    }
}
