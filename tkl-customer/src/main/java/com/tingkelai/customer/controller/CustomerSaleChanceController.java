package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleChanceApi;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.customer.SaleChanceVO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户销售机会处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:17:07
 * @version 1.0
 */
@RestController
public class CustomerSaleChanceController extends BaseCRUDController<SaleChance, Long> implements CustomerSaleChanceApi<SaleChanceVO> {

    @Override
    public ResponseMessage<SaleChanceVO> customerSaleChanceDelete(SaleChanceVO requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleChanceVO> customerSaleChanceGet(SaleChanceVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<SaleChanceVO>> customerSaleChanceListGet(SaleChanceVO requestBody, BasePage basePage) {
        return list(requestBody, basePage);
    }

    @Override
    public ResponseMessage<SaleChanceVO> customerSaleChancePost(SaleChanceVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleChanceVO> customerSaleChancePut(SaleChanceVO requestBody) {
        return updateEntity(requestBody);
    }
}
