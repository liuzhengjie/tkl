package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysRoleApi;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.RoleButton;
import com.tingkelai.domain.sys.RoleMenu;
import com.tingkelai.service.sys.ISysRoleButtonService;
import com.tingkelai.service.sys.ISysRoleMenuService;
import com.tingkelai.service.sys.ISysRoleService;
import com.tingkelai.service.sys.impl.SysRoleButtonServiceImpl;
import com.tingkelai.service.sys.impl.SysRoleMenuServiceImpl;
import com.tingkelai.shiro.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SysRoleController extends BaseCRUDController<Role, Long> implements SysRoleApi<Role> {

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private SysRoleButtonServiceImpl sysRoleButtonService;

    @Autowired
    private SysRoleMenuServiceImpl sysRoleMenuService;

    @Override
    public ResponseMessage<Role> sysRoleDelete(HttpServletRequest request, Role body) {
        return deleteEntity(body);
    }

    @Override
    public ResponseMessage<Role> sysRoleGet(HttpServletRequest request, Role body) {
        return getEntityById(body);
    }

    @Override
    public ResponseMessage<Role> sysRolePost(HttpServletRequest request, Role body) {
        return saveEntity(body);
    }

    @Override
    public ResponseMessage<Role> sysRolePut(HttpServletRequest request, Role body) {
        return updateEntity(body);
    }

    @Override
    public ResponseMessage<List<Role>> sysRoleListGet(HttpServletRequest request, Role body) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<Role> sysRoleLowerLevelRoleDelete(HttpServletRequest request, Role body) {
        return null;
    }

    @Override
    public ResponseMessage<Role> sysRoleLowerLevelRolePost(HttpServletRequest request, Role body) {
        return null;
    }

    @Override
    public ResponseMessage<Role> sysRoleLowerLevelRolePut(HttpServletRequest request, Role body) {
        return null;
    }

//    /**
//     * 设置角色能够控制的菜单
//     * @param request 请求参数，用来处理不好传的参数
//     * @param body 实体类
//     * @return 统一返回结构
//     */
//    @Override
//    public ResponseMessage<Role> sysRoleMenuPost(HttpServletRequest request, RoleMenu body) {
//        ResponseMessage<Role> roleResponseMessage = new ResponseMessage<>();
//        roleResponseMessage.success("权限设置成功");
//        try {
//            String menuIds = request.getParameter("menuIds");
//            if(menuIds != null){
//                String[] arr = menuIds.split(",");
//                for(int i = 0; i < arr.length; i++){
//                    RoleMenu temp = new RoleMenu();
//                    String menuId = arr[i];
//                    temp.setMenuId(Long.parseLong(menuId));
//                    temp.setRoleId(body.getRoleId());
//                    sysRoleMenuService.saveOrUpdate(temp);
//                }
//            }else{
//                sysRoleMenuService.save(body);
//            }
//            //保存用户按钮权限
////            UserUtils.clearCache();
//        } catch (Exception e) {
//            e.printStackTrace();
//            roleResponseMessage.fail("权限设置失败");
//        }
//        return roleResponseMessage;
//    }

    /**
     * 设置角色能够控制的菜单
     * @param request 请求参数，用来处理不好传的参数
     * @param body 实体类
     * @return 统一返回结构
     */
    @Override
    public ResponseMessage<Role> sysRoleMenuPut(HttpServletRequest request, RoleMenu body) {
        ResponseMessage<Role> roleResponseMessage = new ResponseMessage<>();
        roleResponseMessage.success("权限设置成功");
        try {
            Long roleId = body.getRoleId();
            Map<String, Object> map = new HashMap<>();
            map.put("role_id", roleId);
            sysRoleMenuService.removeByMap(map);
            String menuIds = request.getParameter("menuIds");
            if(menuIds != null){
                String[] arr = menuIds.split(",");
                for(int i = 0; i < arr.length; i++){
                    RoleMenu temp = new RoleMenu();
                    temp.setId(body.getId());
                    temp.setRoleId(body.getRoleId());
                    String menuId = arr[i];
                    temp.setMenuId(Long.parseLong(menuId));
                    sysRoleMenuService.saveOrUpdate(temp);
                }
            }else{
                sysRoleMenuService.saveOrUpdate(body);
            }
            //保存用户按钮权限
//            UserUtils.clearCache();
        } catch (Exception e) {
            e.printStackTrace();
            roleResponseMessage.fail("权限设置失败");
        }
        return roleResponseMessage;
    }

//    /**
//     * 设置角色能够控制的按钮
//     * @param request 请求参数，用来处理不好传的参数
//     * @param body 实体类
//     * @return 统一返回结构
//     */
//    @Override
//    public ResponseMessage<Role> sysRoleButtonPost(HttpServletRequest request, RoleButton body) {
//        ResponseMessage<Role> roleResponseMessage = new ResponseMessage<>();
//        roleResponseMessage.success("权限设置成功");
//        try {
//            String buttonIds = request.getParameter("buttonIds");
//            if(buttonIds != null){
//                String[] arr = buttonIds.split(",");
//                for(int i = 0; i < arr.length; i++){
//                    RoleButton tempRoleButton = new RoleButton();
//                    String buttonId = arr[i];
//                    tempRoleButton.setButtonId(Long.parseLong(buttonId));
//                    tempRoleButton.setRoleId(body.getRoleId());
//                    sysRoleButtonService.save(tempRoleButton);
//                }
//            }else{
//                sysRoleButtonService.save(body);
//            }
//            //保存用户按钮权限
////            UserUtils.clearCache();
//        } catch (Exception e) {
//            e.printStackTrace();
//            roleResponseMessage.fail("权限设置失败");
//        }
//        return roleResponseMessage;
//    }

    /**
     * 设置角色能够控制的按钮
     * @param request 请求参数，用来处理不好传的参数
     * @param body 实体类
     * @return 统一返回结构
     */
    @Override
    public ResponseMessage<Role> sysRoleButtonPut(HttpServletRequest request, RoleButton body) {
        ResponseMessage<Role> roleResponseMessage = new ResponseMessage<>();
        roleResponseMessage.success("权限设置成功");
        try {
            Long roleId = body.getRoleId();
            Map<String, Object> map = new HashMap<>();
            map.put("role_id", roleId);
            sysRoleButtonService.removeByMap(map);
            String buttonIds = request.getParameter("buttonIds");
            if(buttonIds != null){
                String[] arr = buttonIds.split(",");
                for(int i = 0; i < arr.length; i++){
                    RoleButton tempRoleButton = new RoleButton();
                    String buttonId = arr[i];
                    tempRoleButton.setId(body.getId());
                    tempRoleButton.setRoleId(body.getRoleId());
                    tempRoleButton.setButtonId(Long.parseLong(buttonId));
                    sysRoleButtonService.saveOrUpdate(tempRoleButton);
                }
            }else{
                sysRoleButtonService.saveOrUpdate(body);
            }
            //保存用户按钮权限
//            UserUtils.clearCache();
        } catch (Exception e) {
            e.printStackTrace();
            roleResponseMessage.fail("权限设置失败");
        }
        return roleResponseMessage;
    }


}
