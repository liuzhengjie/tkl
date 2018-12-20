package com.tingkelai.service.dict.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.domain.template.Template;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.dict.IDictGroupService;
import com.tingkelai.service.dict.IDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("dictItemService")
public class DictItemServiceImpl extends CommonServiceImpl<DictItem> implements IDictItemService {

    private IDictGroupService dictGroupService;

    @Autowired
    public void setDictGroupService(IDictGroupService dictGroupService) {
        this.dictGroupService = dictGroupService;
    }

    @Override
    public IPage<DictItem> page(IPage<DictItem> iPage, Wrapper<DictItem> wrapper) {
        try {
            //设置查询条件
            DictItem dictItem = wrapper.getEntity();
            QueryWrapper<DictItem> queryWrapper = new QueryWrapper<>();

            //分组信息(id或者code是必须的)
            DictCategory dictCategory = dictItem.getDictCategory();
            if(dictCategory.getId() != null){
                queryWrapper.eq("category_id", dictCategory.getId());
            }else if(dictCategory.getCode() != null){
                //获取分类项
                DictCategory tempDictCategory = dictGroupService.getByCode(dictCategory.getCode());
                queryWrapper.eq("category_id", tempDictCategory.getId());
            }else{
                throw new LackParamsException("缺少分组id或者分组code信息");
            }

            //模板名非空，则模糊查询
            if(dictItem.getName() != null){
                queryWrapper.like("name", dictItem.getName());
            }
            //模板code非空，则模糊查询
            if(dictItem.getCode() != null){
                queryWrapper.like("code", dictItem.getCode());
            }

            //获取查询结果
            IPage<DictItem> templateIPage = super.page(iPage, queryWrapper);

            //将公司信息放入结果中
            List<DictItem> resList = templateIPage.getRecords();
            //获取要查询的公司
            Long teamId = dictItem.getTeamId();
            for(DictItem temp : resList){
                temp.setTeamId(teamId);
            }
            templateIPage.setRecords(resList);
            return templateIPage;
        }catch (Exception e){
            throw e;
        }
    }
}
