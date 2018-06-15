package sun.cloud.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.cloud.shiro.service.IShiroUserService;
import sun.cloud.shiro.service.ShiroPasswordService;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 11:14
 * @Desc: 用户身份认证及权限Reaml
 */
public class ShiroDBRealm extends AuthorizingRealm{

    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(ShiroDBRealm.class);

    /**
     * 账户禁用
     */
    private static final String USER_STATUS_FORBIDDEN = "1";

    /**
     * 权限相关用户服务接口
     */
    @Autowired
    private IShiroUserService shiroUserService;

    /**
     * 密码服务类 加密作用
     */
    @Autowired
    private ShiroPasswordService shiroPasswordService;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
