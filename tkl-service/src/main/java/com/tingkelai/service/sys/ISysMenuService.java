package com.tingkelai.service.sys;

import com.tingkelai.domain.sys.Menu;
import com.tingkelai.service.common.ICommonService;

import java.util.List;
import java.util.Set;

/**
 * 菜单service
 *
 * 2018-11-28 17:16:27
 * @author liuzhengjie
 * @version 1.0
 */
public interface ISysMenuService extends ICommonService<Menu> {

    /**
     * 获取指定用户的菜单列表
     * @param id 用户id
     */
    List<Menu> findMenuByUserId(Long id);
}
