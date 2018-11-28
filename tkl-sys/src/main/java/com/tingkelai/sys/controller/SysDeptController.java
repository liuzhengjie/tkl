package com.tingkelai.sys.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysDeptApi;
import com.tingkelai.domain.sys.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysDeptController extends BaseCRUDController<Dept, Long> implements SysDeptApi<Dept> {

    @Override
    public ApiResponseMessage<Dept> sysDeptDelete(HttpServletRequest request, Dept body) {
        return deleteEntity(body);
    }

    @Override
    public ApiResponseMessage<Dept> sysDeptGet(HttpServletRequest request, Dept body) {
        return getEntityById(body);
    }

    @Override
    public ApiResponseMessage<List<Dept>> sysDeptListGet(HttpServletRequest request, Dept body) {
        return getEntityList();
    }

    @Override
    public ApiResponseMessage<Dept> sysDeptPost(HttpServletRequest request, Dept body) {
        return saveEntity(body);
    }

    @Override
    public ApiResponseMessage<Dept> sysDeptPut(HttpServletRequest request, Dept body) {
        return updateEntity(body);
    }
}
