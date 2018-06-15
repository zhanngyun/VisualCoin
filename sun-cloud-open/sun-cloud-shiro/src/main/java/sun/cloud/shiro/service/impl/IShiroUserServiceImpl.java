package sun.cloud.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.cloud.core.orika.OrikaBeanMapper;
import sun.cloud.shiro.domain.ShiroUser;
import sun.cloud.shiro.service.*;
import sun.cloud.shiro.service.dto.*;
import sun.cloud.shiro.service.query.SysMenuQUERY;
import sun.cloud.shiro.service.query.SysRoleMenuQUERY;
import sun.cloud.shiro.service.query.SysUserRoleQUERY;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 11:22
 * @Desc: 用于认证及权限获取相关的UserService 服务接口实现
 */
@Service
public class IShiroUserServiceImpl implements IShiroUserService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;


    @Autowired
    private SysMenuService sysMenuService;


    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private OrikaBeanMapper beanMapper;


    /**
     * 获取权限用户
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public ShiroUser getShiroUser(String userName) {
        SysUserDTO sysUserDTO = sysUserService.get(userName);
        if (sysUserDTO != null) {
            return beanMapper.map(sysUserDTO, ShiroUser.class);
        }
        return null;
    }

    /**
     * 获取用户角色
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public Set<String> getRoles(String userName) {
        Set<String> roles = new HashSet<>();
        SysUserRoleQUERY query = new SysUserRoleQUERY();
        query.setUserName(userName);
        List<SysUserRoleDTO> list = sysUserRoleService.list(query);
        if (list != null) {
            for (SysUserRoleDTO dto : list) {
                SysRoleDTO sysRoleDTO = sysRoleService.get(dto.getRoleId());
                if (sysRoleDTO != null) {
                    roles.add(sysRoleDTO.getRoleId());
                }
            }
        }
        return roles;
    }

    /**
     * 获取用户权限
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public Set<String> getPermissions(String userName) {
        Set<String> roles = getRoles(userName);
        Set<Integer> menus = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        if (roles.size() != 0) {
            for (String role : roles) {
                SysRoleMenuQUERY query = new SysRoleMenuQUERY();
                query.setRoleId(role);
                List<SysRoleMenuDTO> list = sysRoleMenuService.list(query);
                if (list.size() != 0) {
                    for (SysRoleMenuDTO dto : list) {
                        menus.add(dto.getMenuId());
                    }

                }
            }
        }
        if (menus.size() != 0) {
            for (Integer menu : menus) {
                SysMenuDTO sysMenuDTO = sysMenuService.get(menu.longValue());
                if (sysMenuDTO != null) {
                    String[] tempPermissions = sysMenuDTO.getHttpAddress().split(",");//逗号分隔
                    if (tempPermissions.length > 0) {
                        for (String temp : tempPermissions) {
                            permissions.add(temp);
                        }
                    }
                }
            }
        }
        return permissions;
    }


    /**
     * 获取所有的菜单
     * @return
     */
    public List<SysMenuDTO> queryAll(){
        return  sysMenuService.list(new SysMenuQUERY());
    }
}
