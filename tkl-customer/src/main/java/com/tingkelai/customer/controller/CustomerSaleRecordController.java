package com.tingkelai.customer.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleRecordApi;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.service.customer.ISaleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户销售记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:19:07
 * @version 1.0
 */
@RestController
public class CustomerSaleRecordController extends BaseCRUDController<SaleRecord, Long>
        implements CustomerSaleRecordApi<SaleRecord> {


    @Override
    public ApiResponseMessage<SaleRecord> customerSaleRecordDelete(SaleRecord requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<SaleRecord> customerSaleRecordGet(SaleRecord requestBody) {
        return getEntityById(requestBody);
    }

    @Override
    public ApiResponseMessage<List<SaleRecord>> customerSaleRecordListGet(SaleRecord requestBody) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<SaleRecord> customerSaleRecordPost(SaleRecord requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ApiResponseMessage<SaleRecord> customerSaleRecordPut(SaleRecord requestBody) {
        return updateEntity(requestBody);
    }
}
