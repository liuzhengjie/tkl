package com.tingkelai.service.dict.impl;

import com.tingkelai.dao.dict.DictGroupMapper;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.dict.IDictGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictGroupService")
public class DictGroupServiceImpl extends CommonServiceImpl<DictCategory> implements IDictGroupService {
}
