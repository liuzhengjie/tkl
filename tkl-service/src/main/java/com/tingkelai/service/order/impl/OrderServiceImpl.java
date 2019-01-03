package com.tingkelai.service.order.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.order.OrderMapper;
import com.tingkelai.domain.order.Order;
import com.tingkelai.exception.ex300.NoPermissionException;
import com.tingkelai.service.common.ICommonService;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import net.sf.ehcache.search.expression.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单（账单）处理类
 *
 * 2018-11-27 20:36:37
 * @author liuzhengjie
 * @version 1.0
 */
@Service("orderService")
public class OrderServiceImpl extends CommonServiceImpl<Order> implements ICommonService<Order>{

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public IPage<Order> page(IPage<Order> iPage, Wrapper<Order> wrapper) {
        try {
            // 获取查询条件
            Order entity = wrapper.getEntity();
            if(entity.getTeamId() == null){
                throw new NoPermissionException();
            }
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("t.team_id", entity.getTeamId());
            return orderMapper.page(iPage, wrapper);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
