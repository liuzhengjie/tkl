package com.tingkelai.api.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.entity.AbstractEntity;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.ICommonService;
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
			if(entity.getId() == null){
				logger.error("====缺少查询条件");
				return new ResponseMessage<>(new LackParamsException("====缺少查询条件"));
			}
			entity = commonService.getById(entity.getId());
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
			commonService.save(entity);
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
			commonService.saveOrUpdate(entity);
			return new ResponseMessage<>(vo.toVO(entity));
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/** 删除对象，默认按vo的id删除 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> removeEntity(VO vo) {
		return removeEntity(vo, vo.toDTO());
	}

	/** 删除对象，默认按id删除 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> removeEntity(VO vo, Entity entity) {
		try {
			if(entity.getId() == null){
				logger.error("====缺少删除条件");
				LackParamsException exception = new LackParamsException("缺少删除条件");
				return new ResponseMessage<>(exception);
			}
			commonService.removeById(vo.getId());
			return new ResponseMessage<>(vo);
		}catch (Exception e){
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/**
	 * 删除对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> removeEntity(VO vo, Entity entity, Wrapper<Entity> wrapper) {
		try {
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
		return list(vo, vo.toDTO());
	}

	/** 根据条件获取列表，带分页信息 */
	public <VO extends BaseVO<Entity, VO>> ResponseMessage<List<VO>> list(VO vo, Entity entity) {
		return list(vo, entity, null);
	}

	/** 根据条件获取列表，带分页信息 */
	public <VO extends BaseVO<Entity, VO>> ResponseMessage<List<VO>> list(VO vo, Entity entity, BasePage basePage) {
		return list(vo, entity, new EmptyWrapper<>(), basePage);
	}

	/**
	 * 根据条件获取列表，带分页信息
	 */
	public <VO extends BaseVO<Entity, VO>> ResponseMessage<List<VO>> list(VO vo, Entity entity, Wrapper<Entity> wrapper, BasePage basePage) {
		try {
			//设置分页信息，默认第一页，每页显示10条
			Page<Entity> page = new Page<>();
			if(basePage != null){
				page.setCurrent(basePage.getPage());
				page.setSize(basePage.getSize());
			}
			//按条件查询
			if(wrapper == null){
				wrapper = new EmptyWrapper<>();
			}
			IPage<Entity> pageList = commonService.page(page, wrapper);
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
}
