package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.LinkManMapper;
import com.tingkelai.domain.customer.LinkMan;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ILinkmanService;
import org.springframework.stereotype.Service;

@Service("linkmanService")
public class LinkmanServiceImpl extends CommonServiceImpl<LinkManMapper, LinkMan> implements ILinkmanService{
}
