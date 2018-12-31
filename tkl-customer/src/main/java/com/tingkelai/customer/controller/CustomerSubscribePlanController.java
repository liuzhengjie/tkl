package com.tingkelai.customer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSubscribePlanApi;
import com.tingkelai.domain.customer.SubscribePlan;
import com.tingkelai.vo.BasePage;
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
    public ResponseMessage<SubscribePlanVO> customerSubscribePlanDelete(SubscribePlanVO requestBody) {
        QueryWrapper<SubscribePlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", requestBody.getId());
        return removeEntity(requestBody, queryWrapper);
    }

    @Override
    public ResponseMessage<SubscribePlanVO> customerSubscribePlanGet(SubscribePlanVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<SubscribePlanVO>> customerSubscribePlanListGet(SubscribePlanVO requestBody, BasePage basePage) {
        return list(requestBody, basePage);
    }

    @Override
    public ResponseMessage<SubscribePlanVO> customerSubscribePlanPost(SubscribePlanVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<SubscribePlanVO> customerSubscribePlanPut(SubscribePlanVO requestBody) {
        return updateEntity(requestBody);
    }
}
