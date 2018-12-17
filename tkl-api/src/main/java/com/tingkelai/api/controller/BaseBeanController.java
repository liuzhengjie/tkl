package com.tingkelai.api.controller;

import com.tingkelai.util.ReflectionUtils;
import com.tingkelai.util.StringUtils;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.List;

/**
 * 通用controller，用来加载bean
 * @author liuzhengjie
 * @date 2018-11-28 12:15:22
 * @version 1.0
 */
public class BaseBeanController <Entity extends Serializable> extends BaseController{

    /**
     * 实体类型
     */
    protected final Class<Entity> entityClass;

    protected BaseBeanController() {
        this.entityClass = ReflectionUtils.getSuperGenericType(getClass());
    }

    protected Entity newModel() {
        try {
            return entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("can not instantiated model : " + this.entityClass, e);
        }
    }

    /**
     * 共享的验证规则 验证失败返回true
     */
    protected boolean hasError(Entity entity, BindingResult result) {
//        Assert.notNull(entity);
        return result.hasErrors();
    }

    /**
     * 未完成，需要修改
     */
    protected String errorMsg(BindingResult result) {
        String errorMsg = "";
        if (result.getErrorCount() > 0) {
            List<ObjectError> objectErrorList = result.getAllErrors();
            for (ObjectError objectError : objectErrorList) {
/*                String message = MessageUtils.getMessage(objectError.getCode(), objectError.getDefaultMessage(),
                        objectError.getArguments());*/
                String message = objectError.getCode() + objectError.getDefaultMessage();
                if (!StringUtils.isEmpty(message)) {
                    errorMsg = errorMsg + message + "<br />";
                }
            }
        }
        return errorMsg;
    }
}
