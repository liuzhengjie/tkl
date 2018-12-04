package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleChanceApi;
import com.tingkelai.domain.customer.SaleChance;
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
    public ResponseMessage<SaleChance> customerSaleChanceDelete(SaleChanceVO requestBody) {
        return deleteEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<SaleChance> customerSaleChanceGet(SaleChanceVO requestBody) {
        return getEntityById(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<List<SaleChance>> customerSaleChanceListGet(SaleChanceVO requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<SaleChance> customerSaleChancePost(SaleChanceVO requestBody) {
        return saveEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<SaleChance> customerSaleChancePut(SaleChanceVO requestBody) {
        return updateEntity(requestBody.toDTO());
    }
}
