package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.domain.customer.SaleChance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 跟进记录处理mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:43:51
 * @version 1.0
 */
@Mapper
public interface FollowRecordMapper extends BaseMapper<FollowRecord> {

    /** 获取最后一次跟进记录信息（指定销售机会） */
    FollowRecord getLastFollowRecord(@Param("saleChance") SaleChance saleChance);

    @Override
    List<FollowRecord> selectList(@Param(Constants.WRAPPER) Wrapper<FollowRecord> queryWrapper);
}
