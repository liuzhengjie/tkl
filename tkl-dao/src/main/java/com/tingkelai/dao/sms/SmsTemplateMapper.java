package com.tingkelai.dao.sms;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.sms.SmsTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 短信模板mapper
 * 2018-12-18 16:06:36
 * @author liuzhengjie
 * @version 1.0
 */
@Mapper
public interface SmsTemplateMapper extends BaseMapper<SmsTemplate> {

    IPage<SmsTemplate> page(@Param("iPage") IPage<SmsTemplate> iPage, @Param(Constants.WRAPPER) QueryWrapper<SmsTemplate> queryWrapper);

    SmsTemplate getById(@Param("id") Long id);

    SmsTemplate getOne(@Param(Constants.WRAPPER) QueryWrapper<SmsTemplate> queryWrapper);

}