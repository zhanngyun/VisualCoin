package sun.cloud.shiro.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.cloud.core.base.Pagination;
import sun.cloud.core.orika.OrikaBeanMapper;
import sun.cloud.shiro.domain.SysUserRoleDO;
import sun.cloud.shiro.domain.SysUserRoleMapper;
import sun.cloud.shiro.service.SysUserRoleService;
import sun.cloud.shiro.service.bo.SysUserRoleRemoveBO;
import sun.cloud.shiro.service.bo.SysUserRoleSaveBO;
import sun.cloud.shiro.service.dto.SysUserRoleDTO;
import sun.cloud.shiro.service.query.SysUserRoleQUERY;

import java.util.List;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private OrikaBeanMapper beanMapper;


    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysUserRoleDTO> page(SysUserRoleQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysUserRoleDO> sysUserRole = (Page<SysUserRoleDO>) sysUserRoleMapper.list(beanMapper.map(bean, SysUserRoleDO.class));
        Pagination<SysUserRoleDTO> result = new Pagination<>();
        result.setData(beanMapper.mapAsList(sysUserRole, SysUserRoleDTO.class));
        result.setTotal(sysUserRole.getTotal());
        return result;
    }

        /**
         * 查询列表
         * @param bean  查询条件对象
         * @return   分页对象
         * */
    @Override
    public List<SysUserRoleDTO> list(SysUserRoleQUERY bean){
            return beanMapper.mapAsList(sysUserRoleMapper.list(beanMapper.map(bean, SysUserRoleDO.class)),SysUserRoleDTO.class);
        }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysUserRoleSaveBO bean){
        SysUserRoleDO sysUserRole = beanMapper.map(bean, SysUserRoleDO.class);
        sysUserRoleMapper.save(sysUserRole);
        return sysUserRole.getId();
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysUserRoleRemoveBO bean){
        SysUserRoleDO sysUserRole = beanMapper.map(bean, SysUserRoleDO.class);
        return sysUserRoleMapper.remove(sysUserRole);
    }


}
