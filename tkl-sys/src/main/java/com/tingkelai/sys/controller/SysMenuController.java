package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysMenuApi;
import com.tingkelai.domain.sys.Menu;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysMenuController extends BaseCRUDController<Menu, Long> implements SysMenuApi<Menu> {

    @Override
    public ResponseMessage<Menu> sysMenuDelete(HttpServletRequest request, Menu body) {
        return deleteEntity(body);
    }

    @Override
    public ResponseMessage<Menu> sysMenuGet(HttpServletRequest request, Menu body) {
        return getEntityById(body);
    }

    @Override
    public ResponseMessage<List<Menu>> sysMenuListGet(HttpServletRequest request, Menu body) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<Menu> sysMenuPost(HttpServletRequest request, Menu body) {
        return saveEntity(body);
    }

    @Override
    public ResponseMessage<Menu> sysMenuPut(HttpServletRequest request, Menu body) {
        return updateEntity(body);
    }
}
