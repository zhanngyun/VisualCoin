package sun.cloud.shiro.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.cloud.core.base.Pagination;
import sun.cloud.core.orika.OrikaBeanMapper;
import sun.cloud.shiro.domain.SysRoleMenuDO;
import sun.cloud.shiro.domain.SysRoleMenuMapper;
import sun.cloud.shiro.service.SysRoleMenuService;
import sun.cloud.shiro.service.bo.SysRoleMenuRemoveBO;
import sun.cloud.shiro.service.bo.SysRoleMenuSaveBO;
import sun.cloud.shiro.service.dto.SysRoleMenuDTO;
import sun.cloud.shiro.service.query.SysRoleMenuQUERY;

import java.util.List;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private OrikaBeanMapper beanMapper;


    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysRoleMenuDTO> page(SysRoleMenuQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysRoleMenuDO> sysRoleMenu = (Page<SysRoleMenuDO>) sysRoleMenuMapper.list(beanMapper.map(bean, SysRoleMenuDO.class));
        Pagination<SysRoleMenuDTO> result = new Pagination<>();
        result.setData(beanMapper.mapAsList(sysRoleMenu, SysRoleMenuDTO.class));
        result.setTotal(sysRoleMenu.getTotal());
        return result;
    }

        /**
         * 查询列表
         * @param bean  查询条件对象
         * @return   分页对象
         * */
    @Override
    public List<SysRoleMenuDTO> list(SysRoleMenuQUERY bean){
            return beanMapper.mapAsList(sysRoleMenuMapper.list(beanMapper.map(bean, SysRoleMenuDO.class)),SysRoleMenuDTO.class);
        }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysRoleMenuSaveBO bean){
        SysRoleMenuDO sysRoleMenu = beanMapper.map(bean, SysRoleMenuDO.class);
        sysRoleMenuMapper.save(sysRoleMenu);
        return sysRoleMenu.getId();
    }


    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysRoleMenuRemoveBO bean){
        SysRoleMenuDO sysRoleMenu = beanMapper.map(bean, SysRoleMenuDO.class);
        return sysRoleMenuMapper.remove(sysRoleMenu);
    }

}
