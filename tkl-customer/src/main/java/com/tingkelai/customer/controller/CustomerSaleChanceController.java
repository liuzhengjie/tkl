package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleChanceApi;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.service.customer.ISaleChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ApiResponseMessage<SaleChance> customerSaleChanceDelete(SaleChance requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<SaleChance> customerSaleChanceGet(SaleChance requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<List<SaleChance>> customerSaleChanceListGet(SaleChance requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<SaleChance> customerSaleChancePost(SaleChance requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<SaleChance> customerSaleChancePut(SaleChance requestBody) {
        return updateEntity(requestBody);
    }
}
