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

    @Select("select * from tkl_sys_user where id = #{id}")
    @Results(id = "sysUserGet", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "user_name", property = "userName", javaType = String.class),
    })
    User sysUserGet(@Param("id") Long id);

    @Delete("delete from tkl_sys_user where userId = #{id}")
    int sysUserDelete(@Param("id") Long id);

    @Insert("INSERT INTO tkl_sys_user(user_name) VALUES (#{userName});")
    int sysUserPost(@Param("userName") String userName);

    @Update("update tkl_sys_user set user_name = #{userName} where id = #{id}")
    int sysUserPut(@Param("id") Long id, @Param("userName") String userName);

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

}
