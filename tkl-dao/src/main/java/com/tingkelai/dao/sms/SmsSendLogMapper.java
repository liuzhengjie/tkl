package com.tingkelai.dao.sms;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.sms.SmsSendLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 短信记录相关mapper
 * 2018-12-18 16:06:36
 * @author liuzhengjie
 * @version 1.0
 */
@Mapper
public interface SmsSendLogMapper extends BaseMapper<SmsSendLog> {

    IPage<SmsSendLog> page(@Param("iPage") IPage<SmsSendLog> iPage, @Param(Constants.WRAPPER) QueryWrapper<SmsSendLog> queryWrapper);

    SmsSendLog getById(@Param("id") Long id);

    SmsSendLog getOne(@Param(Constants.WRAPPER) QueryWrapper<SmsSendLog> queryWrapper);

}