package com.tingkelai.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<User>{

    List<User> sysUserListGet();

    /** 根据用户id获取用户角色 */
    List<Role> findRoleListByUserId(@Param("id") Long id);

    /** 根据用户id获取用户的所有菜单列表 */
    List<Menu> findMenuByUserId(@Param("id") Long id);

    /** 根据用户id获取用户的所有按钮列表 */
    List<Button> findButtonByUserId(@Param("id") Long id);

    /** 根据username获取用户 */
    User findByUsername(@Param("username") String username);

    /** 根据email获取用户 */
    User findByEmail(@Param("email") String email);

    /** 根据手机号获取用户 */
    User findByPhone(@Param("phone") String phone);

    /** 根据手机号获取用户列表 */
    List<User> findListByPhone(@Param("phone") String phone);

    /** 根据手机号和公司id获取用户信息 */
    User findByPhoneAndTeamId(@Param("phone") String phone, @Param("teamId") String teamId);
}
