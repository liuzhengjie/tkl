package com.tingkelai.api.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.entity.AbstractEntity;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.ICommonService;
import com.tingkelai.service.sys.ISysTeamService;
import com.tingkelai.service.sys.ISysUserService;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.BaseVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * 基础增删改查cotroller
 *
 * @author liuzhengjie
 * 2018-11-28 13:18:35
 * @version 1.0
 * @param <Entity> 实体类
 * @param <ID> 实体类id类型
 */
public abstract class BaseCRUDController<Entity extends AbstractEntity<ID>, ID extends Serializable>
		extends BaseBeanController<Entity>{

	protected static final String METHOD = "method";

	protected ICommonService<Entity> commonService;

	protected ISysTeamService sysTeamService;

	protected ISysUserService sysUserService;

	/**
	 * 设置team service
	 */
	@Autowired
	public void setSysTeamService(ISysTeamService sysTeamService){
		this.sysTeamService = sysTeamService;
	}

	/**
	 * 设置user service
	 */
	@Autowired
	public void setSysUserService(ISysUserService sysUserService){
		this.sysUserService = sysUserService;
	}

	/**
	 * 设置基础service
	 */
	@Autowired
	public void setCommonService(ICommonService<Entity> commonService) {
		this.commonService = commonService;
	}

	/**
	 * 根据id获取对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> getEntity(VO vo) {
		return getEntity(vo, vo.toDTO());
	}

	/**
	 * 保存实体对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> saveEntity(VO vo) {
		return saveEntity(vo, vo.toDTO());
	}

	/**
	 * 修改实体对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> updateEntity(VO vo) {
		return updateEntity(vo, vo.toDTO());
	}

	/**
	 * 删除对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> deleteEntity(VO vo) {
		return removeEntity(vo);
	}

	/**
	 * 获取列表
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<List<VO>> getEntityList(VO vo) {
		return list(vo);
	}

	/** 根据id获取对象 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> getEntity(VO vo, Entity entity){
		try {
			setCurrentTeam(vo);
			QueryWrapper<Entity> queryWrapper = new QueryWrapper<>();
			queryWrapper.setEntity(vo.toDTO());
			entity = commonService.getOne(queryWrapper);
			if(entity == null){
				return new ResponseMessage<>();
			}
			return new ResponseMessage<>(vo.toVO(entity));
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/**
	 * 保存实体对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> saveEntity(VO vo, Entity entity) {
		try {
			setCurrentTeam(vo);
			commonService.save(vo.toDTO());
			return new ResponseMessage<>(vo.toVO(entity));
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/**
	 * 根据id获取对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> getEntity(VO vo, Entity entity, Wrapper<Entity> wrapper) {
		try {
			entity = commonService.getOne(wrapper);
			if(entity == null){
				return new ResponseMessage<>();
			}
			return new ResponseMessage<>(vo.toVO(entity));
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}


	/**
	 * 修改实体对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> updateEntity(VO vo, Entity entity) {
		try {
			setCurrentTeam(vo);
			commonService.saveOrUpdate(vo.toDTO());
			return new ResponseMessage<>(vo.toVO(entity));
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/** 删除对象，默认按vo的id删除 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> removeEntity(VO vo) {
		QueryWrapper<Entity> queryWrapper = new QueryWrapper<>();
		queryWrapper.setEntity(vo.toDTO());
		return removeEntity(vo, queryWrapper);
	}

	/**
	 * 删除对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> removeEntity(VO vo, Wrapper<Entity> wrapper) {
		try {
			setCurrentTeam(vo);
			if(wrapper == null){
				logger.error("====缺少删除条件");
				LackParamsException exception = new LackParamsException("缺少删除条件");
				return new ResponseMessage<>(exception);
			}
			commonService.remove(wrapper);
			ResponseMessage<VO> responseMessage = new ResponseMessage<>();
			responseMessage.setMessage("删除成功");
			return responseMessage;
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/** 根据条件获取列表，带分页信息 */
	public <VO extends BaseVO<Entity, VO>> ResponseMessage<List<VO>> list(VO vo) {
			return list(vo, null);
	}

	/** 根据条件获取列表，带分页信息 */
	public <VO extends BaseVO<Entity, VO>> ResponseMessage<List<VO>> list(VO vo,  BasePage basePage) {
		return list(vo,null, basePage);
	}

	/**
	 * 根据条件获取列表，带分页信息
	 */
	public <VO extends BaseVO<Entity, VO>> ResponseMessage<List<VO>> list(VO vo, Wrapper<Entity> wrapper, BasePage basePage) {
		try {
			setCurrentTeam(vo);
			//设置分页信息，默认第一页，每页显示10条
			Page<Entity> page = new Page<>();
			if(basePage != null){
				page.setCurrent(basePage.getPage());
				page.setSize(basePage.getSize());
			}
			//按条件查询
			QueryWrapper<Entity> queryWrapper = new QueryWrapper<>();
			if(wrapper != null){
				queryWrapper = (QueryWrapper<Entity>) wrapper;
				queryWrapper.setEntity(vo.toDTO());
			}else{
				queryWrapper.setEntity(vo.toDTO());
			}
			IPage<Entity> pageList = commonService.page(page, queryWrapper);
			//查询结果
			List<Entity> list = pageList.getRecords();
			basePage.setTotal(pageList.getTotal());
			basePage.setTotalPages(pageList.getPages());

			//包装成返回对象
			ResponseMessage<List<VO>> responseMessage = new ResponseMessage<>();
			responseMessage.setData(vo.toVO(list));
			responseMessage.setExt(basePage.toMap());
			return responseMessage;
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/**
	 * 将teamId设置到vo里面
	 */
	protected <VO extends BaseVO<Entity, VO>> VO setCurrentTeam(VO vo) throws Exception{
		vo.setTeamId(getCurrentUserTeamId());
		return vo;
	}
}
