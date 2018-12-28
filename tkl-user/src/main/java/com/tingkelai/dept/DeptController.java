package com.tingkelai.dept;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.api.controller.BaseController;
import com.tingkelai.api.user.DeptApi;
import com.tingkelai.api.user.UserApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.sys.impl.SysDeptServiceImpl;
import com.tingkelai.service.sys.impl.SysUserServiceImpl;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * 系统用户处理类
 * 1、获取门店人员
 * 2、通过门店id获取当前门店人员
 *
 * 2018-11-23 16:32:49
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class DeptController extends BaseController implements DeptApi{

    /** 注入部门相关service */
    @Autowired
    private SysDeptServiceImpl sysDeptService;

    /** 注入用户相关servie */
    @Autowired
    private SysUserServiceImpl sysUserService;

    @Override
    public ResponseMessage<List<DeptVO>> deptListGet() {
        // 设置查询条件
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        // 公司id
        Long teamId = getCurrentUserTeamId();
        // 获取当前操作用户username
        Long userId = getCurrentUserId();

        List<Dept> deptList = sysDeptService.getDeptList(teamId, userId);
        DeptVO deptVO = new DeptVO();
        List<DeptVO> deptVOList = deptVO.toVO(deptList);
        return new ResponseMessage<>(deptVOList);
    }

    @Override
    public ResponseMessage<List<UserVO>> deptUserListGet() {
        // 公司id
        Long teamId = getCurrentUserTeamId();
        // 获取当前操作用户username
        Long userId = getCurrentUserId();
        List<User> userList = sysDeptService.getDeptUser(teamId, userId);
        UserVO userVO = new UserVO();
        List<UserVO> userVOList = userVO.toVO(userList);
        return new ResponseMessage<>(userVOList);
    }
}
