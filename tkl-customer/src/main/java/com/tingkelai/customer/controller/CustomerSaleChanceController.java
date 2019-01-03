package com.tingkelai.customer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerSaleChanceApi;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.service.customer.impl.SaleChanceServiceImpl;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.customer.FollowRecordVO;
import com.tingkelai.vo.customer.SaleChanceInfoVO;
import com.tingkelai.vo.customer.SaleChanceListVO;
import com.tingkelai.vo.customer.SaleChanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户销售机会处理类
 *
 * 2018-11-27 14:17:07
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class CustomerSaleChanceController extends BaseCRUDController<SaleChance, Long> implements CustomerSaleChanceApi<SaleChanceVO> {

    @Autowired
    private SaleChanceServiceImpl saleChanceService;

    @Override
    public ResponseMessage<SaleChanceVO> customerSaleChanceDelete(SaleChanceVO requestBody) {
        QueryWrapper<SaleChance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", requestBody.getId());
        return removeEntity(requestBody, queryWrapper);
    }

    @Override
    public ResponseMessage<SaleChanceInfoVO> customerSaleChanceGet(SaleChanceVO requestBody) {
        try{
            ResponseMessage<SaleChanceInfoVO> responseMessage = new ResponseMessage<>();
            // 获取销售机会
            SaleChance saleChance = saleChanceService.getById(requestBody.getId());
            // 获取跟进记录
            List<FollowRecord> followRecordList = saleChanceService.getFollowRecordList(saleChance);
            SaleChanceInfoVO saleChanceInfoVO = new SaleChanceInfoVO();
            saleChanceInfoVO.setSaleChance(new SaleChanceVO(saleChance));
            saleChanceInfoVO.setFollowRecordVOList(new FollowRecordVO().toVO(followRecordList));
            responseMessage.setData(saleChanceInfoVO);
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<List<SaleChanceListVO>> customerSaleChanceListGet(SaleChanceVO requestBody, BasePage basePage) {
        try {
            //设置分页信息，默认第一页，每页显示10条
            Page<SaleChance> page = new Page<>();
            if(basePage != null){
                page.setCurrent(basePage.getPage());
                page.setSize(basePage.getSize());
            }
            //按条件查询
            QueryWrapper<SaleChance> queryWrapper = new QueryWrapper<>();
            requestBody.setTeamId(getCurrentUserTeamId());
            queryWrapper.setEntity(requestBody.toDTO());
            IPage<SaleChance> pageList = commonService.page(page, queryWrapper);
            //查询结果
            List<SaleChance> list = pageList.getRecords();
            basePage.setTotal(pageList.getTotal());
            basePage.setTotalPages(pageList.getPages());

            //包装成返回对象
            ResponseMessage<List<SaleChanceListVO>> responseMessage = new ResponseMessage<>();
            SaleChanceListVO saleChanceListVO = new SaleChanceListVO();
            responseMessage.setData(saleChanceListVO.toVO(list));
            responseMessage.setExt(basePage.toMap());
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<SaleChanceInfoVO> customerSaleChancePost(SaleChanceInfoVO requestBody) {
        try{
            ResponseMessage<SaleChanceInfoVO> responseMessage = new ResponseMessage<>();
            // 转换成dto
            requestBody.setTeamId(getCurrentUserTeamId());
            SaleChance saleChance = requestBody.gainSaleChance();
            List<FollowRecord> followRecordList = requestBody.gainFollowRecordList();
            boolean flag = saleChanceService.saveChanceList(saleChance, followRecordList);
            responseMessage.setMessage("保存成功！");
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<SaleChanceInfoVO> customerSaleChancePut(SaleChanceInfoVO requestBody) {
        try{
            ResponseMessage<SaleChanceInfoVO> responseMessage = new ResponseMessage<>();
            // 转换成dto
            requestBody.setTeamId(getCurrentUserTeamId());
            SaleChance saleChance = requestBody.gainSaleChance();
            List<FollowRecord> followRecordList = requestBody.gainFollowRecordList();
            boolean flag = saleChanceService.updateChanceList(saleChance, followRecordList);
            responseMessage.setMessage("修改成功！");
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }
}
