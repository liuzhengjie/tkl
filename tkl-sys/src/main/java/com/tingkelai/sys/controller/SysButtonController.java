package com.tingkelai.sys.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysButtonApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.vo.sys.ButtonVO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysButtonController extends BaseCRUDController<Button, Long> implements SysButtonApi<ButtonVO> {

    @Override
    public ResponseMessage<List<ButtonVO>> sysButtonListGet(ButtonVO body) {
        return getEntityList(body);
    }

    @Override
    public ResponseMessage<ButtonVO> sysButtonDelete(ButtonVO body) {
        return deleteEntity(body);
    }

    @Override
    public ResponseMessage<ButtonVO> sysButtonGet(ButtonVO body) {
        return getEntity(body);
    }

    @Override
    public ResponseMessage<ButtonVO> sysMenuPost(ButtonVO body) {
        return saveEntity(body);
    }

    @Override
    public ResponseMessage<ButtonVO> sysButtonPut(ButtonVO body) {
        return updateEntity(body);
    }
}
