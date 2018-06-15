package sun.cloud.shiro.service;

import sun.cloud.shiro.domain.ShiroUser;

import java.util.Set;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 11:18
 * @Desc: 用于认证及权限获取相关的UserService 服务接口
 */
public interface IShiroUserService {

    /**
     * 获取权限用户
     * @param userName 用户名
     * @return
     */
    ShiroUser getShiroUser(String userName);

    /**
     * 获取用户角色，以字符串表示
     * @param userName  用户名
     * @return
     */
    Set<String> getRoles(String userName);

    /**
     * 获取用户权限，以字符串表示
     * @param userName 用户名
     * @return
     */
    Set<String> getPermissions(String userName);
}
