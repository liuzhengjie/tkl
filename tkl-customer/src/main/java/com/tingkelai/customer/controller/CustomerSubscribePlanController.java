package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSubscribePlanApi;
import com.tingkelai.domain.customer.SubscribePlan;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户预约计划处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:22:00
 * @version 1.0
 */
@RestController
public class CustomerSubscribePlanController extends BaseCRUDController<SubscribePlan, Long>
        implements CustomerSubscribePlanApi<SubscribePlan> {

    @Override
    public ResponseMessage<SubscribePlan> customerSubscribePlanDelete(SubscribePlan requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<SubscribePlan> customerSubscribePlanGet(SubscribePlan requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ResponseMessage<List<SubscribePlan>> customerSubscribePlanListGet(SubscribePlan requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<SubscribePlan> customerSubscribePlanPost(SubscribePlan requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<SubscribePlan> customerSubscribePlanPut(SubscribePlan requestBody) {
        return updateEntity(requestBody);
    }
}
