package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.customer.ContactRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 联系人处理mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:42:05
 * @version 1.0
 */
@Mapper
public interface ContactRecordMapper extends BaseMapper<ContactRecord> {
}
