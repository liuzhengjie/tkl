package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleProductRecordApi;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.service.customer.ISaleProductRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户销售产品处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:18:10
 * @version 1.0
 */
@RestController
public class CustomerSaleProductRecordController extends BaseCRUDController<SaleProductRecord, Long>
        implements CustomerSaleProductRecordApi<SaleProductRecord> {

    @Override
    public ApiResponseMessage<SaleProductRecord> customerSaleProductRecordDelete(SaleProductRecord requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<SaleProductRecord> customerSaleProductRecordGet(SaleProductRecord requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<List<SaleProductRecord>> customerSaleProductRecordListGet(SaleProductRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<SaleProductRecord> customerSaleProductRecordPost(SaleProductRecord requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<SaleProductRecord> customerSaleProductRecordPut(SaleProductRecord requestBody) {
        return updateEntity(requestBody);
    }
}
