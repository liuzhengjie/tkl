package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysButtonApi;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.vo.sys.ButtonVO;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SysButtonController extends BaseCRUDController<Button, Long> implements SysButtonApi<ButtonVO> {

    @Override
    public ResponseMessage<List<Button>> sysButtonListGet(ButtonVO body) {
        List<ButtonVO> resList = new ArrayList<>();
        try{
            List<Button> list = commonService.list();
            return new ResponseMessage<>(list);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<Button> sysButtonDelete(ButtonVO body) {
        return deleteEntity(body.toDTO());
    }

    @Override
    public ResponseMessage<Button> sysButtonGet(ButtonVO body) {
        return getEntityById(body.toDTO());
    }

    @Override
    public ResponseMessage<Button> sysMenuPost(ButtonVO body) {
        return saveEntity(body.toDTO());
    }

    @Override
    public ResponseMessage<Button> sysButtonPut(ButtonVO body) {
        return updateEntity(body.toDTO());
    }
}
