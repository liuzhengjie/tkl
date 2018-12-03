package com.tingkelai.api.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.dao.customer.CustomerMapper;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.domain.entity.AbstractEntity;
import com.tingkelai.service.common.ICommonService;
import com.tingkelai.service.common.impl.CommonServiceImpl;
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
	protected ResponseMessage<List<Entity>> getEntityList() {
		try{
			List<Entity> list = commonService.list();
			return new ResponseMessage<>(list);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/**
	 * 根据id获取对象
	 */
	protected ResponseMessage<Entity> getEntityById(Entity entity) {
		try{
			entity = commonService.getById(entity.getId());
			return new ResponseMessage<>(entity);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/**
	 * 保存实体对象
	 */
	protected ResponseMessage<Entity> saveEntity(Entity entity) {
		try{
			commonService.save(entity);
			return new ResponseMessage<>(entity);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	/**
	 * 修改实体对象
	 */
	protected ResponseMessage<Entity> updateEntity(Entity entity) {
		try{
			commonService.saveOrUpdate(entity);
			return new ResponseMessage<>(entity);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}

	protected ResponseMessage<Entity> deleteEntity(Entity entity) {
		try{
			commonService.removeById(entity.getId());
			return new ResponseMessage<>(entity);
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ResponseMessage<>(e);
		}
	}
}
