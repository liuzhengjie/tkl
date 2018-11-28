package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.customer.ServiceRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 服务记录mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:50:46
 * @version 1.0
 */
@Mapper
public interface ServiceRecordMapper extends BaseMapper<ServiceRecord> {
}
