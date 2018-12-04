package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleRecordApi;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.vo.customer.SaleRecordVO;
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
        implements CustomerSaleRecordApi<SaleRecordVO> {


    @Override
    public ResponseMessage<SaleRecord> customerSaleRecordDelete(SaleRecordVO requestBody) {
        return deleteEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<SaleRecord> customerSaleRecordGet(SaleRecordVO requestBody) {
        return getEntityById(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<List<SaleRecord>> customerSaleRecordListGet(SaleRecordVO requestBody) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<SaleRecord> customerSaleRecordPost(SaleRecordVO requestBody) {
        return saveEntity(requestBody.toDTO());
    }

    @Override
    public ResponseMessage<SaleRecord> customerSaleRecordPut(SaleRecordVO requestBody) {
        return updateEntity(requestBody.toDTO());
    }
}
