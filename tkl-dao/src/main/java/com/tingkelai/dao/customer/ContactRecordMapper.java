package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.ContactRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 联系人处理mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:42:05
 * @version 1.0
 */
@Mapper
public interface ContactRecordMapper extends BaseMapper<ContactRecord> {
    IPage<ContactRecord> page(@Param("iPage") IPage<ContactRecord> iPage, @Param(Constants.WRAPPER) QueryWrapper<ContactRecord> queryWrapper);

    ContactRecord getById(Long id);
}
