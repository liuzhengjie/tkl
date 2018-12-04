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
    public ResponseMessage<TeamVO> sysTeamGet(TeamVO vo) {
        return getEntity(vo);
    }

    @Override
    public ResponseMessage<TeamVO> sysTeamPost(TeamVO vo) {
        return saveEntity(vo);
    }

    @Override
    public ResponseMessage<TeamVO> sysTeamPut(TeamVO vo) {
        return updateEntity(vo);
    }
}
