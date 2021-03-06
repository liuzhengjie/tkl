package com.tingkelai.customer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleRecordApi;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.service.customer.ISaleRecordService;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.customer.SaleRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ISaleRecordService saleRecordService;

    @Override
    public ResponseMessage<SaleRecordVO> customerSaleRecordDelete(SaleRecordVO requestBody) {
        QueryWrapper<SaleRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", requestBody.getId());
        return removeEntity(requestBody, queryWrapper);
    }

    @Override
    public ResponseMessage<SaleRecordVO> customerSaleRecordGet(SaleRecordVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<SaleRecordVO>> customerSaleRecordListGet(SaleRecordVO requestBody, BasePage basePage) {
        return list(requestBody, basePage);
    }

    @Override
    public ResponseMessage<SaleRecordVO> customerSaleRecordPost(SaleRecordVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleRecordVO> customerSaleRecordPut(SaleRecordVO requestBody) {
        return updateEntity(requestBody);
    }
}
