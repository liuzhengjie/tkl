package com.tingkelai.api.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.entity.AbstractEntity;
import com.tingkelai.service.common.ICommonService;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.ButtonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		Entity entity = vo.toDTO();
		entity = commonService.getById(entity.getId());
		return new ResponseMessage<>(vo.toVO(entity));
	}

	/**
	 * 保存实体对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> saveEntity(VO vo) {
		Entity entity = vo.toDTO();
		commonService.save(entity);
		vo = vo.toVO(entity);
		return new ResponseMessage<>(vo);
	}

	/**
	 * 修改实体对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> updateEntity(VO vo) {
		Entity entity = vo.toDTO();
		commonService.saveOrUpdate(entity);
		return new ResponseMessage<>(vo.toVO(entity));
	}

	/**
	 * 删除对象
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<VO> deleteEntity(VO vo) {
		Entity entity = vo.toDTO();
		commonService.removeById(entity.getId());
		return new ResponseMessage<>(vo.toVO(entity));
	}

	/**
	 * 获取列表
	 */
	protected <VO extends BaseVO<Entity, VO>> ResponseMessage<List<VO>> getEntityList(VO vo) {
		List<Entity> list = commonService.list();
		List<VO> resList = vo.toVO(list);
		return new ResponseMessage<>(resList);
	}
}
