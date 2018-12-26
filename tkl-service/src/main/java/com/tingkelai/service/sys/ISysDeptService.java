package com.tingkelai.service.sys;

import com.tingkelai.domain.sys.Dept;
import com.tingkelai.service.common.ICommonService;

import java.util.List;

/**
 * 部门service
 *
 * @author liuzhengjie
 * @date 2018-11-28 17:15:25
 * @version 1.0
 */
public interface ISysDeptService extends ICommonService<Dept> {

    /** 通过用户获取指定公司的门店列表 */
    List<Dept> getShopList(Long userId, Long teamId) throws Exception;
}
