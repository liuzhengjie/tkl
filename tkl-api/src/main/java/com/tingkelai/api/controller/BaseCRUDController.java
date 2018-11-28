package com.tingkelai.api.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.domain.entity.AbstractEntity;
import com.tingkelai.service.common.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * 基础增删改查cotroller
 *
 * @author liuzhengjie
 * @date 2018-11-28 13:18:35
 * @version 1.0
 * @param <Entity> 实体类
 * @param <ID> 实体类id类型
 */
public abstract class BaseCRUDController<Entity extends AbstractEntity<ID>, ID extends Serializable>
		extends BaseBeanController<Entity> {

	protected ICommonService<Entity> commonService;

	/**
	 * 设置基础service
	 */
	@Autowired
	public void setCommonService(ICommonService<Entity> commonService) {
		this.commonService = commonService;
	}

	/**
	 * 获取列表
	 */
	protected ApiResponseMessage<List<Entity>> getEntityList() {
		try{
			List<Entity> list = commonService.list();
			return new ApiResponseMessage<>(list);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ApiResponseMessage<>(e);
		}
	}

	/**
	 * 根据id获取对象
	 */
	protected ApiResponseMessage<Entity> getEntityById(Entity entity) {
		try{
			entity = commonService.getById(entity.getId());
			return new ApiResponseMessage<>(entity);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ApiResponseMessage<>(e);
		}
	}

	/**
	 * 保存实体对象
	 */
	protected ApiResponseMessage<Entity> saveEntity(Entity entity) {
		try{
			commonService.save(entity);
			return new ApiResponseMessage<>(entity);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ApiResponseMessage<>(e);
		}
	}

	/**
	 * 修改实体对象
	 */
	protected ApiResponseMessage<Entity> updateEntity(Entity entity) {
		try{
			commonService.saveOrUpdate(entity);
			return new ApiResponseMessage<>(entity);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ApiResponseMessage<>(e);
		}
	}

	protected ApiResponseMessage<Entity> deleteEntity(Entity entity) {
		try{
			commonService.removeById(entity.getId());
			return new ApiResponseMessage<>(entity);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ApiResponseMessage<>(e);
		}
	}
}
