package com.tingkelai.customer.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleProductRecordApi;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.vo.BasePage;
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
    public ResponseMessage<SaleProductRecordVO> customerSaleProductRecordDelete(SaleProductRecordVO requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleProductRecordVO> customerSaleProductRecordGet(SaleProductRecordVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<SaleProductRecordVO>> customerSaleProductRecordListGet(SaleProductRecordVO requestBody, BasePage basePage) {
        return list(requestBody, basePage);
    }

    @Override
    public ResponseMessage<SaleProductRecordVO> customerSaleProductRecordPost(SaleProductRecordVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleProductRecordVO> customerSaleProductRecordPut(SaleProductRecordVO requestBody) {
        return updateEntity(requestBody);
    }
}
