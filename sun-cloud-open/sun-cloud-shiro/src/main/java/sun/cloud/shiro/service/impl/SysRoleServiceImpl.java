package sun.cloud.shiro.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.cloud.core.base.Pagination;
import sun.cloud.core.orika.OrikaBeanMapper;
import sun.cloud.shiro.domain.SysRoleDO;
import sun.cloud.shiro.domain.SysRoleMapper;
import sun.cloud.shiro.service.SysRoleService;
import sun.cloud.shiro.service.bo.SysRoleRemoveBO;
import sun.cloud.shiro.service.bo.SysRoleSaveBO;
import sun.cloud.shiro.service.bo.SysRoleUpdateBO;
import sun.cloud.shiro.service.dto.SysRoleDTO;
import sun.cloud.shiro.service.query.SysRoleQUERY;

import java.util.Date;
import java.util.List;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private OrikaBeanMapper beanMapper;

    /**
     * 获取单个对象
     *
     * @param id 主键
     * @return 结果对象
     */
    @Override
    public SysRoleDTO get(String id) {
        return beanMapper.map(sysRoleMapper.get(id), SysRoleDTO.class);
    }

    /**
     * 查询对象列表
     *
     * @param bean 查询条件对象
     * @return 分页对象
     */
    @Override
    public Pagination<SysRoleDTO> page(SysRoleQUERY bean) {
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysRoleDO> sysRole = (Page<SysRoleDO>) sysRoleMapper.list(beanMapper.map(bean, SysRoleDO.class));
        Pagination<SysRoleDTO> result = new Pagination<>();
        result.setData(beanMapper.mapAsList(sysRole, SysRoleDTO.class));
        result.setTotal(sysRole.getTotal());
        return result;
    }

    /**
     * 查询列表
     *
     * @param bean 查询条件对象
     * @return 分页对象
     */
    @Override
    public List<SysRoleDTO> list(SysRoleQUERY bean) {
        return beanMapper.mapAsList(sysRoleMapper.list(beanMapper.map(bean, SysRoleDO.class)), SysRoleDTO.class);
    }

    /**
     * 保存单个对象,返回主键
     *
     * @param bean 保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysRoleSaveBO bean) {
        SysRoleDO sysRole = beanMapper.map(bean, SysRoleDO.class);
        sysRoleMapper.save(sysRole);
        return sysRole.getId();
    }

    /**
     * 更新单个对象 id必须有
     *
     * @param bean 更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysRoleUpdateBO bean) {
        SysRoleDO sysRole = beanMapper.map(bean, SysRoleDO.class);
        return sysRoleMapper.update(sysRole);
    }

    /**
     * 按条件删除对象
     *
     * @param bean 条件对象
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysRoleRemoveBO bean) {
        SysRoleDO sysRole = beanMapper.map(bean, SysRoleDO.class);
        return sysRoleMapper.remove(sysRole);
    }

    /**
     * 按主键删除对象
     *
     * @param id 主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id) {
        return sysRoleMapper.delete(id);
    }
}
