package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.customer.HandlerRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 经手人记录处理mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:44:57
 * @version 1.0
 */
@Mapper
public interface HandlerRecordMapper extends BaseMapper<HandlerRecord> {
}
