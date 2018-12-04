package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysDeptApi;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysDeptController extends BaseCRUDController<Dept, Long> implements SysDeptApi<DeptVO> {

    @Override
    public ResponseMessage<Dept> sysDeptDelete(DeptVO deptVO) {
        return deleteEntity(deptVO.toDTO());
    }

    @Override
    public ResponseMessage<Dept> sysDeptGet(DeptVO deptVO) {
        return getEntityById(deptVO.toDTO());
    }

    @Override
    public ResponseMessage<List<Dept>> sysDeptListGet(DeptVO deptVO) {
        return getEntityList();
    }

    @Override
    public ResponseMessage<Dept> sysDeptPost(DeptVO deptVO) {
        return saveEntity(deptVO.toDTO());
    }

    @Override
    public ResponseMessage<Dept> sysDeptPut(DeptVO deptVO) {
        return updateEntity(deptVO.toDTO());
    }


}
