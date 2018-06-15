package sun.cloud.shiro.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.cloud.core.base.Pagination;
import sun.cloud.core.orika.OrikaBeanMapper;
import sun.cloud.shiro.domain.SysUserDO;
import sun.cloud.shiro.domain.SysUserMapper;
import sun.cloud.shiro.service.SysUserService;
import sun.cloud.shiro.service.bo.SysUserRemoveBO;
import sun.cloud.shiro.service.bo.SysUserSaveBO;
import sun.cloud.shiro.service.bo.SysUserUpdateBO;
import sun.cloud.shiro.service.dto.SysUserDTO;
import sun.cloud.shiro.service.query.SysUserQUERY;

import java.util.List;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private OrikaBeanMapper beanMapper;

    /**
     * 获取单个对象
     *
     * @param id 主键
     * @return 结果对象
     */
    @Override
    public SysUserDTO get(String id) {
        return beanMapper.map(sysUserMapper.get(id), SysUserDTO.class);
    }

    /**
     * 查询对象列表
     *
     * @param bean 查询条件对象
     * @return 分页对象
     */
    @Override
    public Pagination<SysUserDTO> page(SysUserQUERY bean) {
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysUserDO> sysUser = (Page<SysUserDO>) sysUserMapper.list(beanMapper.map(bean, SysUserDO.class));
        Pagination<SysUserDTO> result = new Pagination<>();
        result.setData(beanMapper.mapAsList(sysUser, SysUserDTO.class));
        result.setTotal(sysUser.getTotal());
        return result;
    }

    /**
     * 查询列表
     *
     * @param bean 查询条件对象
     * @return 分页对象
     */
    @Override
    public List<SysUserDTO> list(SysUserQUERY bean) {
        return beanMapper.mapAsList(sysUserMapper.list(beanMapper.map(bean, SysUserDO.class)), SysUserDTO.class);
    }

    /**
     * 保存单个对象,返回主键
     *
     * @param bean 保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysUserSaveBO bean) {
        SysUserDO sysUser = beanMapper.map(bean, SysUserDO.class);
        sysUserMapper.save(sysUser);
        return sysUser.getId();
    }

    /**
     * 更新单个对象 id必须有
     *
     * @param bean 更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysUserUpdateBO bean) {
        SysUserDO sysUser = beanMapper.map(bean, SysUserDO.class);
        return sysUserMapper.update(sysUser);
    }

    /**
     * 按条件删除对象
     *
     * @param bean 条件对象
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysUserRemoveBO bean) {
        SysUserDO sysUser = beanMapper.map(bean, SysUserDO.class);
        return sysUserMapper.remove(sysUser);
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
        return sysUserMapper.delete(id);
    }
}
