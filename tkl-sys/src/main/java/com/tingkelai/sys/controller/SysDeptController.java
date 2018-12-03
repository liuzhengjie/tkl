package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysDeptApi;
import com.tingkelai.domain.sys.Dept;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysDeptController extends BaseCRUDController<Dept, Long> implements SysDeptApi<Dept> {

    @Override
    public ResponseMessage<Dept> sysDeptDelete(HttpServletRequest request, Dept body) {
        return deleteEntity(body);
    }

    @Override
    public ResponseMessage<Dept> sysDeptGet(HttpServletRequest request, Dept body) {
        return getEntityById(body);
    }

    @Override
    public ResponseMessage<List<Dept>> sysDeptListGet(HttpServletRequest request, Dept body) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<Dept> sysDeptPost(HttpServletRequest request, Dept body) {
        return saveEntity(body);
    }

    @Override
    public ResponseMessage<Dept> sysDeptPut(HttpServletRequest request, Dept body) {
        return updateEntity(body);
    }
}
