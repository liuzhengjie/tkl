package com.tingkelai.service.template.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.domain.template.Template;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysTeamService;
import com.tingkelai.service.template.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 动态模板相关
 *
 * 2018-12-17 10:55:22
 * @author liuzhengjie
 * @version 1.0
 */
@Transactional
@Service("templateService")
public class TemplateServiceImpl extends CommonServiceImpl<Template> implements ITemplateService {

    @Autowired
    private ISysTeamService sysTeamService;

    @Override
    public IPage<Template> page(IPage<Template> iPage, Wrapper<Template> wrapper) {
        try {
            //设置查询条件
            Template template = wrapper.getEntity();
            QueryWrapper<Template> queryWrapper = new QueryWrapper<>();
            //查询条件要有公司，必须
            queryWrapper.eq("team_id", template.getTeam().getId() + "");
            //模板名非空，则模糊查询
            if(template.getName() != null){
                queryWrapper.like("name", template.getName());
            }
            //模板code非空，则模糊查询
            if(template.getCode() != null){
                queryWrapper.like("code", template.getCode());
            }

            //获取查询结果
            IPage<Template> templateIPage = super.page(iPage, queryWrapper);

            //将公司信息放入结果中
            List<Template> resList = templateIPage.getRecords();
            //获取要查询的公司
            Team team = template.getTeam();
            for(Template temp : resList){
                temp.setTeam(team);
            }
            templateIPage.setRecords(resList);
            return templateIPage;
        }catch (Exception e){
            throw e;
        }
    }
}
