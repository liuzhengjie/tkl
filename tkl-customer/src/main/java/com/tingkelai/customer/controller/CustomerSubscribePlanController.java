package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSubscribePlanApi;
import com.tingkelai.domain.customer.SubscribePlan;
import com.tingkelai.service.customer.ISubscribePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ApiResponseMessage<SubscribePlan> customerSubscribePlanDelete(SubscribePlan requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<SubscribePlan> customerSubscribePlanGet(SubscribePlan requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<List<SubscribePlan>> customerSubscribePlanListGet(SubscribePlan requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<SubscribePlan> customerSubscribePlanPost(SubscribePlan requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<SubscribePlan> customerSubscribePlanPut(SubscribePlan requestBody) {
        return updateEntity(requestBody);
    }
}
