package com.tingkelai.service.sys.impl;

import com.tingkelai.domain.sys.Team;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysTeamService;
import org.springframework.stereotype.Service;

@Service("sysTeamService")
public class SysTeamServiceImpl extends CommonServiceImpl<Team> implements ISysTeamService{
}
