package com.tingkelai.service.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.service.common.ICommonService;

/**
 * 客户主表处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:36:37
 * @version 1.0
 */
public interface ISaleRecordService extends ICommonService<SaleRecord>{
    IPage<SaleRecord> pageAll(Page<SaleRecord> page, QueryWrapper<SaleRecord> queryWrapper);
}
