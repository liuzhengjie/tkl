package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysMenuApi;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.vo.sys.MenuVO;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysMenuController extends BaseCRUDController<Menu, Long> implements SysMenuApi<MenuVO> {

    @Override
    public ResponseMessage<Menu> sysMenuDelete(MenuVO body) {
        return deleteEntity(body.toDTO());
    }

    @Override
    public ResponseMessage<Menu> sysMenuGet(MenuVO body) {
        return getEntityById(body.toDTO());
    }

    @Override
    public ResponseMessage<List<Menu>> sysMenuListGet(MenuVO body) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<Menu> sysMenuPost(MenuVO body) {
        return saveEntity(body.toDTO());
    }

    @Override
    public ResponseMessage<Menu> sysMenuPut(MenuVO body) {
        return updateEntity(body.toDTO());
    }
}
