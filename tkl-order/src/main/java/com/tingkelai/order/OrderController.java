package com.tingkelai.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.order.OrderApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.domain.order.Order;
import com.tingkelai.service.customer.ISaleRecordService;
import com.tingkelai.service.customer.impl.SaleProductRecordServiceImpl;
import com.tingkelai.service.order.IOrderService;
import com.tingkelai.service.order.impl.OrderServiceImpl;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.customer.SaleProductRecordVO;
import com.tingkelai.vo.customer.SaleRecordVO;
import com.tingkelai.vo.order.OrderVO;
import com.tingkelai.vo.order.SaleOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户销售记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:19:07
 * @version 1.0
 */
@RestController(value = "orderController")
public class OrderController extends BaseCRUDController<SaleRecord, Long> implements OrderApi<SaleRecordVO>{

    @Autowired
    private ISaleRecordService saleRecordService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private SaleProductRecordServiceImpl saleProductRecordService;

    @Override
    public ResponseMessage<SaleRecordVO> orderDelete(SaleRecordVO requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<SaleOrderVO> orderGet(SaleRecordVO requestBody) {
        try{
            Long teamId = getCurrentUserTeamId();
            // 获取销售记录
            SaleRecord saleRecord = saleRecordService.getById(requestBody.getId());
            // 获取销售产品列表
//            List<SaleProductRecord> saleProductRecordList = saleRecordService
            QueryWrapper<SaleProductRecord> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("team_id", teamId);
            queryWrapper.eq("sale_record_id", saleRecord.getId());
            queryWrapper.eq("del_flag", 0);
            List<SaleProductRecord> saleProductRecordList = saleProductRecordService.list(queryWrapper);
            SaleOrderVO saleOrderVO = new SaleOrderVO(saleRecord, saleProductRecordList);
            return new ResponseMessage<>(saleOrderVO);
        }catch (Exception e){
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<List<OrderVO>> orderListGet(OrderVO requestBody, BasePage basePage) {
        try {
            // 设置租户信息
            requestBody.setTeamId(getCurrentUserTeamId());
            // 设置分页信息，默认第一页，每页显示10条
            Page<Order> page = new Page<>();
            if(basePage != null){
                page.setCurrent(basePage.getPage());
                page.setSize(basePage.getSize());
            }
            //按条件查询
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            queryWrapper.setEntity(requestBody.toDTO());
            IPage<Order> pageList = orderService.page(page, queryWrapper);
            //查询结果
            List<Order> list = pageList.getRecords();
            basePage.setTotal(pageList.getTotal());
            basePage.setTotalPages(pageList.getPages());

            //包装成返回对象
            ResponseMessage<List<OrderVO>> responseMessage = new ResponseMessage<>();
            responseMessage.setData(requestBody.toVO(list));
            responseMessage.setExt(basePage.toMap());
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<SaleOrderVO> orderPost(SaleOrderVO saleOrderVO) {
        try{
            Long teamId = getCurrentUserTeamId();
            ResponseMessage<SaleOrderVO> responseMessage = new ResponseMessage<>();
            // 要保存的销售订单基本信息
            SaleRecord saleRecord = saleOrderVO.getSaleRecord().toDTO();
            saleRecord.setTeamId(teamId);
            // 要保存的销售产品列表
            List<SaleProductRecord> saleProductRecordList = new ArrayList<>();
            List<SaleProductRecordVO> saleProductRecordVOList = saleOrderVO.getSaleProductRecordList();
            for(SaleProductRecordVO saleProductRecordVO : saleProductRecordVOList){
                saleProductRecordVO.setTeamId(teamId);
            }
            SaleProductRecordVO saleProductRecordVO = new SaleProductRecordVO();
            saleProductRecordList = saleProductRecordVO.toDTO(saleProductRecordVOList);

            boolean flag = saleRecordService.saveSaleOrder(saleRecord, saleProductRecordList);
            responseMessage.setMessage("保存成功！");
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<SaleOrderVO> orderPut(SaleOrderVO saleOrderVO) {
        try{
            Long teamId = getCurrentUserTeamId();
            ResponseMessage<SaleOrderVO> responseMessage = new ResponseMessage<>();
            // 要保存的销售产品列表
            List<SaleProductRecord> saleProductRecordList = new ArrayList<>();
            List<SaleProductRecordVO> saleProductRecordVOList = saleOrderVO.getSaleProductRecordList();
            for(SaleProductRecordVO saleProductRecordVO : saleProductRecordVOList){
                saleProductRecordVO.setTeamId(teamId);
            }
            SaleProductRecordVO saleProductRecordVO = new SaleProductRecordVO();
            saleProductRecordList = saleProductRecordVO.toDTO(saleProductRecordVOList);
            // 要保存的销售订单基本信息
            SaleRecord saleRecord = saleOrderVO.getSaleRecord().toDTO();
            saleRecord.setTeamId(teamId);
            boolean flag = saleRecordService.updateSaleOrder(saleRecord, saleProductRecordList);
            responseMessage.setMessage("修改成功！");
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }
}
