package com.tingkelai.service.customer.impl;

import com.tingkelai.domain.customer.ContactRecord;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IContactRecordService;
import org.springframework.stereotype.Service;

/**
 * 联系记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-29 10:10:50
 * @version 1.0
 */
@Service("contactRecordService")
public class ContactRecordServiceImpl extends CommonServiceImpl<ContactRecord> implements IContactRecordService{

/*    private ICommonService<ContactRecord> commonService;

    @Autowired
    public void setCommonService(ICommonService<ContactRecord> commonService) {
        this.commonService = commonService;
    }

    @Override
    public List<ContactRecord> list() {
        return commonService.list();
    }

    @Override
    public boolean save(ContactRecord contactRecord) {
        return commonService.save(contactRecord);
    }

    @Override
    public boolean removeById(Serializable serializable) {
        return commonService.removeById(serializable);
    }

    @Override
    public boolean saveOrUpdate(ContactRecord contactRecord) {
        return commonService.saveOrUpdate(contactRecord);
    }

    @Override
    public ContactRecord getById(Serializable serializable) {
        return commonService.getById(serializable);
    }*/
}
