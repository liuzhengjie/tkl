package com.tingkelai.service.sys;


import com.tingkelai.domain.sys.User;
import com.tingkelai.service.common.ICommonService;

import java.util.List;

public interface ISysUserService extends ICommonService<User> {

    User sysUserGet(Long id);

    User sysUserDelete(Long id);

    User sysUserPost(User user);

    User sysUserPut(User user);

    List<User> sysUserListGet();
}
