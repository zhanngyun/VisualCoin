package sun.cloud.shiro.service.impl;

import sun.cloud.shiro.service.SysMenuService;
import sun.cloud.shiro.domain.SysMenuMapper;
import sun.cloud.shiro.domain.SysMenuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import sun.cloud.core.base.Pagination;
import sun.cloud.core.orika.OrikaBeanMapper;
import sun.cloud.shiro.service.bo.SysMenuSaveBO;
import sun.cloud.shiro.service.query.SysMenuQUERY;
import sun.cloud.shiro.service.bo.SysMenuRemoveBO;
import sun.cloud.shiro.service.dto.SysMenuDTO;
import sun.cloud.shiro.service.bo.SysMenuUpdateBO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */


@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private OrikaBeanMapper beanMapper;

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    @Override
    public SysMenuDTO get(Long id){
        return beanMapper.map(sysMenuMapper.get(id),SysMenuDTO.class);
    }

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    @Override
    public Pagination<SysMenuDTO> page(SysMenuQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<SysMenuDO> sysMenu = (Page<SysMenuDO>) sysMenuMapper.list(beanMapper.map(bean, SysMenuDO.class));
        Pagination<SysMenuDTO> result = new Pagination<>();
        result.setData(beanMapper.mapAsList(sysMenu, SysMenuDTO.class));
        result.setTotal(sysMenu.getTotal());
        return result;
    }

        /**
         * 查询列表
         * @param bean  查询条件对象
         * @return   分页对象
         * */
    @Override
    public List<SysMenuDTO> list(SysMenuQUERY bean){
            return beanMapper.mapAsList(sysMenuMapper.list(beanMapper.map(bean, SysMenuDO.class)),SysMenuDTO.class);
        }

    /**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(SysMenuSaveBO bean){
        SysMenuDO sysMenu = beanMapper.map(bean, SysMenuDO.class);
        sysMenuMapper.save(sysMenu);
        return sysMenu.getId();
    }

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(SysMenuUpdateBO bean){
        SysMenuDO sysMenu = beanMapper.map(bean, SysMenuDO.class);
        return sysMenuMapper.update(sysMenu);
    }

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(SysMenuRemoveBO bean){
        SysMenuDO sysMenu = beanMapper.map(bean, SysMenuDO.class);
        return sysMenuMapper.remove(sysMenu);
    }

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        return sysMenuMapper.delete(id);
        }
}
