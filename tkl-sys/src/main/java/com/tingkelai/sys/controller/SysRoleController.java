package com.tingkelai.sys.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysRoleApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.RoleButton;
import com.tingkelai.domain.sys.RoleMenu;
import com.tingkelai.service.sys.ISysRoleService;
import com.tingkelai.service.sys.impl.SysRoleButtonServiceImpl;
import com.tingkelai.service.sys.impl.SysRoleMenuServiceImpl;
import com.tingkelai.vo.sys.RoleButtonVO;
import com.tingkelai.vo.sys.RoleMenuVO;
import com.tingkelai.vo.sys.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SysRoleController extends BaseCRUDController<Role, Long> implements SysRoleApi<RoleVO> {

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private SysRoleButtonServiceImpl sysRoleButtonService;

    @Autowired
    private SysRoleMenuServiceImpl sysRoleMenuService;

    @Override
    public ResponseMessage<RoleVO> sysRoleDelete(RoleVO vo) {
        return deleteEntity(vo);
    }

    @Override
    public ResponseMessage<RoleVO> sysRoleGet(RoleVO vo) {
        return getEntity(vo);
    }

    @Override
    public ResponseMessage<RoleVO> sysRolePost(RoleVO vo) {
        return saveEntity(vo);
    }

    @Override
    public ResponseMessage<RoleVO> sysRolePut(RoleVO vo) {
        return updateEntity(vo);
    }

    @Override
    public ResponseMessage<List<RoleVO>> sysRoleListGet(RoleVO vo) {
        return getEntityList(vo);
    }

    @Override
    public ResponseMessage<RoleVO> sysRoleLowerLevelRoleDelete(RoleVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<RoleVO> sysRoleLowerLevelRolePost(RoleVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<RoleVO> sysRoleLowerLevelRolePut(RoleVO vo) {
        return null;
    }


    /**
     * 设置角色能够控制的菜单
     * @param body 实体类
     * @return 统一返回结构
     */
    @Override
    public ResponseMessage sysRoleMenuPut(RoleMenuVO body) {
        ResponseMessage roleResponseMessage = new ResponseMessage<>();
        roleResponseMessage.success("权限设置成功");
        try {
            Long roleId = body.getRoleId();
            Map<String, Object> map = new HashMap<>();
            map.put("role_id", roleId);
            sysRoleMenuService.removeByMap(map);
            String menuIds = getParameter("menuIds");
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
                sysRoleMenuService.saveOrUpdate(new RoleMenu());
            }
            //保存用户按钮权限
//            UserUtils.clearCache();
        } catch (Exception e) {
            e.printStackTrace();
            roleResponseMessage.fail("权限设置失败");
        }
        return roleResponseMessage;
    }

    /**
     * 设置角色能够控制的按钮
     * @param body 实体类
     * @return 统一返回结构
     */
    @Override
    public ResponseMessage sysRoleButtonPut(RoleButtonVO body) {
        ResponseMessage roleResponseMessage = new ResponseMessage<>();
        roleResponseMessage.success("权限设置成功");
        try {
            Long roleId = body.getRoleId();
            Map<String, Object> map = new HashMap<>();
            map.put("role_id", roleId);
            sysRoleButtonService.removeByMap(map);
            String buttonIds = getParameter("buttonIds");
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
                sysRoleButtonService.saveOrUpdate(new RoleButton());
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
