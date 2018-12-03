package com.tingkelai.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.sys.RoleButton;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * 按钮角色中间表mapper类
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
public interface SysRoleButtonMapper extends BaseMapper<RoleButton>{


}
