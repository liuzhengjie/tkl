package com.tingkelai.sys.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysRoleApi;
import com.tingkelai.domain.sys.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysRoleController extends BaseCRUDController<Role, Long> implements SysRoleApi<Role> {

    @Override
    public ApiResponseMessage<Role> sysRoleDelete(HttpServletRequest request, Role body) {
        return deleteEntity(body);
    }

    @Override
    public ApiResponseMessage<Role> sysRoleGet(HttpServletRequest request, Role body) {
        return getEntityById(body);
    }

    @Override
    public ApiResponseMessage<List<Role>> sysRoleListGet(HttpServletRequest request, Role body) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<Role> sysRoleLowerLevelRoleDelete(HttpServletRequest request, Role body) {
        return null;
    }

    @Override
    public ApiResponseMessage<Role> sysRoleLowerLevelRolePost(HttpServletRequest request, Role body) {
        return null;
    }

    @Override
    public ApiResponseMessage<Role> sysRoleLowerLevelRolePut(HttpServletRequest request, Role body) {
        return null;
    }

    @Override
    public ApiResponseMessage<Role> sysRoleMenuListPost(HttpServletRequest request, Role body) {
        return null;
    }

    @Override
    public ApiResponseMessage<Role> sysRoleMenuListPut(HttpServletRequest request, Role body) {
        return null;
    }

    @Override
    public ApiResponseMessage<Role> sysRolePost(HttpServletRequest request, Role body) {
        return saveEntity(body);
    }

    @Override
    public ApiResponseMessage<Role> sysRolePut(HttpServletRequest request, Role body) {
        return updateEntity(body);
    }
}
