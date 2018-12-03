package com.tingkelai.service.sys;

import com.tingkelai.domain.sys.Button;
import com.tingkelai.service.common.ICommonService;

import java.util.List;

/**
 * 按钮处理service
 *
 * @author liuzhengjie
 * @date 2018-11-28 17:13:16
 * @version 1.0
 */
public interface ISysButtonService extends ICommonService<Button> {

    /**
     * 获取指定用户的所有有权限的按钮
     * @param id 用户id
     * @return 按钮列表
     */
    List<Button> findButtonByUserId(Long id);
}
