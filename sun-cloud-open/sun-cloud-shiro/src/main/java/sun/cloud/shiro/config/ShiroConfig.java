package sun.cloud.shiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.cloud.shiro.filter.ShiroFormAuthenticationFilter;
import sun.cloud.shiro.filter.ShiroPermissionsAuthorizationFilter;
import sun.cloud.shiro.filter.ShiroUserFilter;
import sun.cloud.shiro.filter.SysUserFilter;
import sun.cloud.shiro.jcaptcha.JCaptchaValidateFilter;
import sun.cloud.shiro.realm.ShiroDBRealm;
import sun.cloud.shiro.service.ShiroPasswordService;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 11:26
 * @Desc: shiro的相关配置
 */
@Configuration
public class ShiroConfig {


    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.password}")
    private String password;

    /**
     * shiro密码服务类
     * @return
     */
    @Bean
    public ShiroPasswordService shiroPasswordService() {
        return new ShiroPasswordService();
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        Map filterMap = new LinkedHashMap<>();
        filterMap.put("authc",shiroFormAuthenticationFilter());
        filterMap.put("perm",shiroPermissionsAuthorizationFilter());
        filterMap.put("captcha",jCaptchaValidateFilter());
        filterMap.put("sysUser",sysUserFilter());
        filterMap.put("user",shiroUserFilter());
        shiroFilterFactoryBean.setFilters(filterMap);


        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //注意过滤器配置顺序 不能颠倒
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        filterChainDefinitionMap.put("/logout", "logout");
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/ajaxLogin", "captcha,authc");
        filterChainDefinitionMap.put("/login", "captcha,authc");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/jcaptcha.jpeg", "anon");
        filterChainDefinitionMap.put("/403", "anon");
        filterChainDefinitionMap.put("/login.html", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/welcome.html", "user,sysUser");
        filterChainDefinitionMap.put("/admin/user/modifyPwd.html", "user,sysUser");
        filterChainDefinitionMap.put("/admin/user/updatePassword", "user,sysUser");
        filterChainDefinitionMap.put("/admin/user/role/list", "user,sysUser");
        filterChainDefinitionMap.put("/**", "user,sysUser,perm");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public ShiroFormAuthenticationFilter shiroFormAuthenticationFilter(){
        return new ShiroFormAuthenticationFilter();
    }

    @Bean
    public ShiroPermissionsAuthorizationFilter shiroPermissionsAuthorizationFilter(){
        return new ShiroPermissionsAuthorizationFilter();
    }

    @Bean
    public JCaptchaValidateFilter jCaptchaValidateFilter(){
        return new JCaptchaValidateFilter();
    }

    @Bean
    public SysUserFilter sysUserFilter(){
        return new SysUserFilter();
    }

    @Bean
    public ShiroUserFilter shiroUserFilter(){
        return new ShiroUserFilter();
    }


    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

    @Bean
    public ShiroDBRealm myShiroRealm() {
        ShiroDBRealm myShiroRealm = new ShiroDBRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
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
        MySessionManager mySessionManager = new MySessionManager();
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
        redisManager.setExpire(1800);// 配置缓存过期时间
        redisManager.setTimeout(timeout);
        redisManager.setPassword(password);
        return redisManager;
    }

    @Bean
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
     *
     * @param securityManager
     * @return
     */
   /* @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }*/


}
