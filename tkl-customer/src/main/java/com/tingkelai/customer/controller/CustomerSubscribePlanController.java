package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSubscribePlanApi;
import com.tingkelai.domain.customer.SubscribePlan;
import com.tingkelai.vo.customer.SubscribePlanVO;
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
        implements CustomerSubscribePlanApi<SubscribePlanVO> {

    @Override
    public ResponseMessage<SubscribePlan> customerSubscribePlanDelete(SubscribePlanVO requestBody) {
        return deleteEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<SubscribePlan> customerSubscribePlanGet(SubscribePlanVO requestBody) {
        return getEntityById(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<List<SubscribePlan>> customerSubscribePlanListGet(SubscribePlanVO requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<SubscribePlan> customerSubscribePlanPost(SubscribePlanVO requestBody) {
        return saveEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<SubscribePlan> customerSubscribePlanPut(SubscribePlanVO requestBody) {
        return updateEntity(requestBody.toDTO());
    }
}
