package com.tingkelai.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.sys.RoleMenu;
import com.tingkelai.domain.sys.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * 用户角色中间表mapper类
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
public interface SysUserRoleMapper extends BaseMapper<UserRole>{

}
