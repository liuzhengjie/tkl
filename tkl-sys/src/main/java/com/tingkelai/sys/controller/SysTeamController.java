package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysTeamApi;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.sys.TeamVO;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SysTeamController extends BaseCRUDController<Team, Long> implements SysTeamApi<TeamVO> {

    @Override
    public ResponseMessage<Team> sysTeamGet(TeamVO vo) {
        return getEntityById(vo.toDTO());
    }

    @Override
    public ResponseMessage<Team> sysTeamPost(TeamVO vo) {
        return saveEntity(vo.toDTO());
    }

    @Override
    public ResponseMessage<Team> sysTeamPut(TeamVO vo) {
        return updateEntity(vo.toDTO());
    }
}
