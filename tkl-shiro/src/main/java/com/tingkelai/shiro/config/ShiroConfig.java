package com.tingkelai.shiro.config;

import com.tingkelai.shiro.authc.credential.RetryLimitHashedCredentialsMatcher;
import com.tingkelai.shiro.filter.SysUserFilter;
import com.tingkelai.shiro.realm.UserRealm;
import com.tingkelai.shiro.session.SessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import com.tingkelai.shiro.filter.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置类
 *
 * 2018-11-29 14:41:38
 * @author liuzhengjie
 * @version 1.0
 */
//@Configuration
public class ShiroConfig {
    /** redis相关参数 */
    @Value("${spring.redis.shiro.host}")
    private String host;
    @Value("${spring.redis.shiro.port}")
    private int port;
    @Value("${spring.redis.shiro.timeout}")
    private int timeout;
    @Value("${spring.redis.shiro.password}")
    private String password;

    /** shiro相关参数 */
    @Value(value = "${shiro.credentials.hashAlgorithmName}")
    private String algorithmName = "md5";
    @Value(value = "${shiro.credentials.hashIterations}")
    private final int hashIterations = 2;

    /** 自定义认证器 */
    private RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher(){
        RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(algorithmName);
        credentialsMatcher.setHashIterations(hashIterations);
        return credentialsMatcher;
    }

    /** 自定义过滤器 */
    //表单过滤器
    private FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
    //用户过滤器
    private SysUserFilter sysUserFilter = new SysUserFilter();

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //自定义filter过滤器
        Map<String, Filter> filterMap = new HashMap<>();
        //添加表单过滤器
        filterMap.put("formAuthenticationFilter", formAuthenticationFilter);
        filterMap.put("sysUserFilter", sysUserFilter);
        filterMap.put("anon", new AnonymousFilter());

        System.out.println(shiroFilterFactoryBean.getFilters());

        // 定义过滤链
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/", "anon");
        // swagger不进行拦截
        filterChainDefinitionMap.put("/swagger-ui.html/**", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/api-docs/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        //系统用拦截器
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        filterChainDefinitionMap.put("/toLogin", "anon");
        filterChainDefinitionMap.put("/regist/**", "anon");
        filterChainDefinitionMap.put("/v1/**", "formAuthenticationFilter");
        filterChainDefinitionMap.put("/**", "anon");
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/ajaxLogin");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/toLogin");
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        System.out.println(shiroFilterFactoryBean.getFilters());
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义shiro域
     * @return
     */
    @Bean
    public UserRealm myShiroRealm() {
        UserRealm myShiroRealm = new UserRealm();
        myShiroRealm.setCredentialsMatcher(retryLimitHashedCredentialsMatcher());
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    //自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        SessionManager mySessionManager = new SessionManager();
        mySessionManager.setSessionDAO(redisSessionDAO());
        return mySessionManager;
    }

    /**
     * 配置shiro redisManager
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setTimeout(timeout);
        redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    @Bean("ehcacheManager")
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * <p>
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

//    /**
//     * 注册全局异常处理
//     */
//    @Bean(name = "exceptionHandler")
//    public HandlerExceptionResolver handlerExceptionResolver() {
//        return new MyExceptionHandler();
//    }
}
