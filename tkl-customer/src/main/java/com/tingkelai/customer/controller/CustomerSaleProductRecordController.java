package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleProductRecordApi;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.vo.customer.SaleProductRecordVO;
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
        implements CustomerSaleProductRecordApi<SaleProductRecordVO> {

    @Override
    public ResponseMessage<SaleProductRecord> customerSaleProductRecordDelete(SaleProductRecordVO requestBody) {
        return deleteEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<SaleProductRecord> customerSaleProductRecordGet(SaleProductRecordVO requestBody) {
        return getEntityById(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<List<SaleProductRecord>> customerSaleProductRecordListGet(SaleProductRecordVO requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<SaleProductRecord> customerSaleProductRecordPost(SaleProductRecordVO requestBody) {
        return saveEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<SaleProductRecord> customerSaleProductRecordPut(SaleProductRecordVO requestBody) {
        return updateEntity(requestBody.toDTO());
    }
}
