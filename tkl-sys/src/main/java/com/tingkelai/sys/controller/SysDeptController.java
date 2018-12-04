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
    public ResponseMessage<DeptVO> sysDeptDelete(DeptVO deptVO) {
        return deleteEntity(deptVO);
    }

    @Override
    public ResponseMessage<DeptVO> sysDeptGet(DeptVO deptVO) {
        return getEntity(deptVO);
    }

    @Override
    public ResponseMessage<List<DeptVO>> sysDeptListGet(DeptVO deptVO) {
        return getEntityList(deptVO);
    }

    @Override
    public ResponseMessage<DeptVO> sysDeptPost(DeptVO deptVO) {
        return saveEntity(deptVO);
    }

    @Override
    public ResponseMessage<DeptVO> sysDeptPut(DeptVO deptVO) {
        return updateEntity(deptVO);
    }


}
