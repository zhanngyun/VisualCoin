package sun.cloud.shiro.realm;

import org.apache.shiro.SecurityUtils;
import sun.cloud.shiro.domain.ShiroUser;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 15:00
 * @Desc: shiro用户工具类
 */
public class ShiroUserUtils {

    private static final String IS_ADMIN = "1";

    public static ShiroUser toUser(Object object) {
        return (ShiroUser) object;
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static ShiroUser getUser() {
        return toUser(SecurityUtils.getSubject().getPrincipal());
    }

    /**
     * 是否是超级管理员
     *
     * @return
     */
    public static boolean isAdmin() {
        ShiroUser shiroUser = toUser(SecurityUtils.getSubject().getPrincipal());
        return IS_ADMIN.equals(shiroUser.getIsAdmin());
    }
}
