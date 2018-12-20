package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.LinkMan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 联系人mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:45:49
 * @version 1.0
 */
@Mapper
public interface LinkManMapper extends BaseMapper<LinkMan> {
    IPage<LinkMan> page(@Param("iPage") IPage<LinkMan> iPage, @Param(Constants.WRAPPER) QueryWrapper<LinkMan> queryWrapper);

    LinkMan getById(Long id);
}
