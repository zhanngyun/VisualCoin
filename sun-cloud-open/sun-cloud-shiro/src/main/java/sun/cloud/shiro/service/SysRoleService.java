
package sun.cloud.shiro.service;

import sun.cloud.core.base.Pagination;
import sun.cloud.shiro.service.bo.SysRoleRemoveBO;
import sun.cloud.shiro.service.bo.SysRoleSaveBO;
import sun.cloud.shiro.service.bo.SysRoleUpdateBO;
import sun.cloud.shiro.service.dto.SysRoleDTO;
import sun.cloud.shiro.service.query.SysRoleQUERY;

import java.util.List;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface SysRoleService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    SysRoleDTO get(String id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<SysRoleDTO> page(SysRoleQUERY bean);

    /**
     * 查询列表
     * @param bean  查询条件对象
     * @return   集合对象
     * */
    List<SysRoleDTO> list(SysRoleQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(SysRoleSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(SysRoleUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(SysRoleRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}