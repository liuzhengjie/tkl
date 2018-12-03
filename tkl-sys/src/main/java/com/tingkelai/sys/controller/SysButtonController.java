package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysButtonApi;
import com.tingkelai.domain.sys.Button;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysButtonController extends BaseCRUDController<Button, Long> implements SysButtonApi<Button> {

    @Override
    public ResponseMessage<List<Button>> sysButtonListGet(HttpServletRequest request, Button body) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<Button> sysButtonDelete(HttpServletRequest request, Button body) {
        return deleteEntity(body);
    }

    @Override
    public ResponseMessage<Button> sysButtonGet(HttpServletRequest request, Button body) {
        return getEntityById(body);
    }

    @Override
    public ResponseMessage<Button> sysMenuPost(HttpServletRequest request, Button body) {
        return saveEntity(body);
    }

    @Override
    public ResponseMessage<Button> sysButtonPut(HttpServletRequest request, Button body) {
        return updateEntity(body);
    }
}
