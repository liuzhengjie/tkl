package com.tingkelai.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.domain.sys.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 系统按钮权限mapper类
 *
 * 不建议在该接口中直接写sql方法，约定所有sql写在xml文件中
 * 原因：便于管理和阅读
 *
 * @author liuzhengjie
 * @date 2018-11-26 10:38:17
 * @version 1.0
 */
@Component
@Mapper
public interface SysButtonMapper extends BaseMapper<Button>{

    List<Button> findButtonByUserId(@Param("userId") Long userId);

}
