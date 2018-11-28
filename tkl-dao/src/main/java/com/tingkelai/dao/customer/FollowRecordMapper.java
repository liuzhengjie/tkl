package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.customer.FollowRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 跟进记录处理mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:43:51
 * @version 1.0
 */
@Mapper
public interface FollowRecordMapper extends BaseMapper<FollowRecord> {
}
