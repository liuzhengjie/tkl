package com.tingkelai.shiro.config;

import com.tingkelai.shiro.authc.credential.StatelessCredentialsMatcher;
import com.tingkelai.shiro.filter.FormAuthenticationFilter;
import com.tingkelai.shiro.filter.StatelessAuthenticationFilter;
import com.tingkelai.shiro.filter.SysUserFilter;
import com.tingkelai.shiro.realm.StatelessUserRealm;
import com.tingkelai.shiro.realm.UserRealm;
import com.tingkelai.shiro.session.SessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
public class StatelessShiroConfig {
    /** shiro相关参数 */
    @Value(value = "${shiro.credentials.hashAlgorithmName}")
    private String algorithmName = "md5";
    @Value(value = "${shiro.credentials.hashIterations}")
    private final int hashIterations = 2;
    @Value(value = "${shiro.credentials.storedCredentialsHexEncoded}")
    private final boolean storedCredentialsHexEncoded = true;

    /** 自定义认证器 */
    private StatelessCredentialsMatcher statelessCredentialsMatcher(){
        StatelessCredentialsMatcher credentialsMatcher = new StatelessCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(algorithmName);
        credentialsMatcher.setHashIterations(hashIterations);
        credentialsMatcher.setStoredCredentialsHexEncoded(storedCredentialsHexEncoded);
        return credentialsMatcher;
    }

    /** 自定义过滤器 */
    private StatelessAuthenticationFilter statelessAuthenticationFilter = new StatelessAuthenticationFilter();

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //自定义filter过滤器
        Map<String, Filter> filterMap = new HashMap<>();
        //添加表单过滤器
        filterMap.put("anon", new AnonymousFilter());
        filterMap.put("statelessAuthenticationFilter", statelessAuthenticationFilter);
        //定义过滤链
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        filterChainDefinitionMap.put("/toLogin", "anon");
        filterChainDefinitionMap.put("/getToken", "anon");
        filterChainDefinitionMap.put("/v1/**", "statelessAuthenticationFilter");
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/ajaxLogin");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/toLogin");
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义认证域
     */
    @Bean
    public StatelessUserRealm statelessShiroRealm() {
        StatelessUserRealm myShiroRealm = new StatelessUserRealm();
        myShiroRealm.setCredentialsMatcher(statelessCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 安全管理器
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(statelessShiroRealm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * 自定义sessionManager,禁用会话管理器
     */
    @Bean
    public SessionManager sessionManager() {
        SessionManager statelessSessionManager = new SessionManager();
        statelessSessionManager.setSessionValidationSchedulerEnabled(false);
        return statelessSessionManager;
    }

    /**
     * 开启shiro aop注解支持.
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
