package com.tingkelai.sys.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.controller.BaseController;
import com.tingkelai.api.sys.SysUserApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.User;
import com.tingkelai.domain.sys.UserRole;
import com.tingkelai.service.sys.ISysUserService;
import com.tingkelai.service.sys.impl.SysUserRoleServiceImpl;
import com.tingkelai.vo.sys.UserRoleVO;
import com.tingkelai.vo.sys.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户处理类
 *
 * @author liuzhengjie
 * @date 2018-11-23 16:32:49
 * @version 1.0
 */
@RestController
public class SysUserController extends BaseCRUDController<User, Long> implements SysUserApi<UserVO> {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysUserRoleServiceImpl sysUserRoleService;

    private static final Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Override
    public ResponseMessage<List<UserVO>> sysUserListGet(UserVO userVO) {
        return getEntityList(userVO);
    }

    @Override
    public ResponseMessage<UserVO> sysUserDelete(UserVO userVO) {
        return deleteEntity(userVO);
    }

    public ResponseMessage<UserVO> sysUserGet(UserVO userVO) {
        return getEntity(userVO);
    }

    @Override
    public ResponseMessage<UserVO> sysUserPost(UserVO userVO) {
        return saveEntity(userVO);
    }

    @Override
    public ResponseMessage<UserVO>  sysUserPut(UserVO userVO) {
        return updateEntity(userVO);
    }

    @Override
    public ResponseMessage sysUserRolePost(UserRoleVO body) {
        ResponseMessage roleResponseMessage = new ResponseMessage<>();
        roleResponseMessage.success("权限设置成功");
        try {
            //获取用户id
            Long userId = body.getUserId();
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", userId);
            sysUserRoleService.removeByMap(map);
            String roleIds = getParameter("roleIds");
            if(roleIds != null){
                String[] arr = roleIds.split(",");
                for(int i = 0; i < arr.length; i++){
                    UserRole temp = new UserRole();
                    temp.setId(body.getId());
                    String roleId = arr[i];
                    temp.setRoleId(Long.parseLong(roleId));
                    temp.setUserId(body.getUserId());
                    sysUserRoleService.saveOrUpdate(temp);
                }
            }else{
                sysUserRoleService.saveOrUpdate(body.toDTO());
            }
            //保存用户按钮权限
//            UserUtils.clearCache();
        } catch (Exception e) {
            e.printStackTrace();
            roleResponseMessage.fail("权限设置失败");
        }
        return roleResponseMessage;
    }

    @Override
    public ResponseMessage changePassword(String username, String password) {
        ResponseMessage responseMessage = new ResponseMessage<>();
        responseMessage.success("修改密码成功");
        sysUserService.changePassword(username, password);
        return responseMessage;
    }

}
