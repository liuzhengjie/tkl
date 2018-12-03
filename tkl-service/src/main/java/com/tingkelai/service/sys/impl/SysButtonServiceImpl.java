package com.tingkelai.service.sys.impl;

import com.tingkelai.domain.sys.Button;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysButtonService")
public class SysButtonServiceImpl extends CommonServiceImpl<Button> implements ISysButtonService {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Override
    public List<Button> findButtonByUserId(Long id) {
        List<Button> buttonList = sysUserService.findButtonListByUserId(id);
        return buttonList;
    }
}
