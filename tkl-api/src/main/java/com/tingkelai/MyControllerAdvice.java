package com.tingkelai;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.exception.BaseException;
import com.tingkelai.shiro.jwt.JwtUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;


/**
 * controller 增强器 原理是使用AOP对Controller控制器进行增强（前置增强、后置增强、环绕增强）
 * 启动应用后，被 @ExceptionHandler、@InitBinder、@ModelAttribute 注解的方法，都会作用在 被 @RequestMapping 注解的方法上。
 *
 * 参考url：https://www.cnblogs.com/sxdcgaq8080/p/8797318.html
 */
@ControllerAdvice
public class MyControllerAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("sys", "tingkelai");
    }


    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseMessage errorHandler(Exception ex) {
        return new ResponseMessage(ex);
    }

    /**
     * 无权限异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler({ UnauthorizedException.class })
    public ResponseMessage unauthenticatedHandler(Exception ex) {
        return new ResponseMessage(ex);
    }

    /**
     * 拦截捕捉自定义异常 BaseException.class
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public ResponseMessage myErrorHandler(BaseException ex) {
        return new ResponseMessage(ex);
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        if(o instanceof ResponseMessage){
//            ServletServerHttpResponse response = (ServletServerHttpResponse)serverHttpResponse;
//            HttpServletResponse httpServletResponse = response.getServletResponse();
//            String token = httpServletResponse.getHeader(JwtUtil.TOKEN_NAME);
//            if(token != null){
//                ((ResponseMessage) o).setToken(token);
//            }
//        }
        return o;
    }
}
