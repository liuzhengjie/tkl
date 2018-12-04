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
    public ResponseMessage<MenuVO> sysMenuDelete(MenuVO body) {
        return deleteEntity(body);
    }

    @Override
    public ResponseMessage<MenuVO> sysMenuGet(MenuVO body) {
        return getEntity(body);
    }

    @Override
    public ResponseMessage<List<MenuVO>> sysMenuListGet(MenuVO body) {
        return getEntityList(body);
    }

    @Override
    public ResponseMessage<MenuVO> sysMenuPost(MenuVO body) {
        return saveEntity(body);
    }

    @Override
    public ResponseMessage<MenuVO> sysMenuPut(MenuVO body) {
        return updateEntity(body);
    }
}
