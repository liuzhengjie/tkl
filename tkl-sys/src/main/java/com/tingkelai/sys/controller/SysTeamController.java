package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysTeamApi;
import com.tingkelai.domain.sys.Team;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SysTeamController extends BaseCRUDController<Team, Long> implements SysTeamApi<Team> {

    @Override
    public ResponseMessage<Team> sysTeamGet(HttpServletRequest request, Team body) {
        return getEntityById(body);
    }

    @Override
    public ResponseMessage<Team> sysTeamPost(HttpServletRequest request, Team body) {
        return saveEntity(body);
    }

    @Override
    public ResponseMessage<Team> sysTeamPut(HttpServletRequest request, Team body) {
        return updateEntity(body);
    }
}
