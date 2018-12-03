package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleChanceApi;
import com.tingkelai.domain.customer.SaleChance;
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
public class CustomerSaleChanceController extends BaseCRUDController<SaleChance, Long> implements CustomerSaleChanceApi<SaleChance> {

    @Override
    public ResponseMessage<SaleChance> customerSaleChanceDelete(SaleChance requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleChance> customerSaleChanceGet(SaleChance requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ResponseMessage<List<SaleChance>> customerSaleChanceListGet(SaleChance requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<SaleChance> customerSaleChancePost(SaleChance requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleChance> customerSaleChancePut(SaleChance requestBody) {
        return updateEntity(requestBody);
    }
}
