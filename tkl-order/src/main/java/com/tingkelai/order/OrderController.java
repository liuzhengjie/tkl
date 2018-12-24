package com.tingkelai.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.order.OrderApi;
import com.tingkelai.domain.ResponseMessage;
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
@RestController(value = "orderController2")
public class OrderController extends BaseCRUDController<SaleRecord, Long> implements OrderApi<SaleRecordVO>{

    @Autowired
    private ISaleRecordService saleRecordService;

    @Override
    public ResponseMessage<SaleRecordVO> orderDelete(SaleRecordVO requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleRecordVO> orderGet(SaleRecordVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<SaleRecordVO>> orderListGet(SaleRecordVO requestBody, BasePage basePage) {
        try {
            setCurrentTeam(requestBody);
            //设置分页信息，默认第一页，每页显示10条
            Page<SaleRecord> page = new Page<>();
            if(basePage != null){
                page.setCurrent(basePage.getPage());
                page.setSize(basePage.getSize());
            }
            //按条件查询
            QueryWrapper<SaleRecord> queryWrapper = new QueryWrapper<>();
            queryWrapper.setEntity(requestBody.toDTO());
            IPage<SaleRecord> pageList = saleRecordService.pageAll(page, queryWrapper);
            //查询结果
            List<SaleRecord> list = pageList.getRecords();
            basePage.setTotal(pageList.getTotal());
            basePage.setTotalPages(pageList.getPages());

            //包装成返回对象
            ResponseMessage<List<SaleRecordVO>> responseMessage = new ResponseMessage<>();
            responseMessage.setData(requestBody.toVO(list));
            responseMessage.setExt(basePage.toMap());
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<SaleRecordVO> orderPost(SaleRecordVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleRecordVO> orderPut(SaleRecordVO requestBody) {
        return updateEntity(requestBody);
    }
}
