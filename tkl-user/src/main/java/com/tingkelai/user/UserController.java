package com.tingkelai.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.api.controller.BaseController;
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
public class UserController  extends BaseController implements UserApi{

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private SysDeptServiceImpl sysDeptService;

    @Override
    public ResponseMessage<UserVO> userGet() {
        try{
            //获取当前用户id
            Long userId = getCurrentUserId();
            User user = sysUserService.getById(userId);
            return new ResponseMessage<>(new UserVO(user));
        }catch (Exception e){
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<List<DeptVO>> shopGet() {
        try{
            //获取当前用户id
            Long userId = getCurrentUserId();
            //获取当前用户所属公司id
            Long teamId = getCurrentUserTeamId();
            //获取当前用户能看到的所有门店列表
            List<Dept> deptList = sysDeptService.getShopList(userId, teamId);
            DeptVO deptVO = new DeptVO();
            return new ResponseMessage<>(deptVO.toVO(deptList));
        }catch (Exception e){
            return new ResponseMessage<>(e);
        }
    }
}
