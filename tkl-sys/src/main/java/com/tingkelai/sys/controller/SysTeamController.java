package com.tingkelai.sys.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysTeamApi;
import com.tingkelai.domain.sys.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SysTeamController extends BaseCRUDController<Team, Long> implements SysTeamApi<Team> {

    @Override
    public ApiResponseMessage<Team> sysTeamGet(HttpServletRequest request, Team body) {
        return getEntityById(body);
    }

    @Override
    public ApiResponseMessage<Team> sysTeamPost(HttpServletRequest request, Team body) {
        return saveEntity(body);
    }

    @Override
    public ApiResponseMessage<Team> sysTeamPut(HttpServletRequest request, Team body) {
        return updateEntity(body);
    }
}
