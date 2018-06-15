
package sun.cloud.shiro.service;
import java.util.List;
import sun.cloud.shiro.service.bo.SysUserRoleSaveBO;
import sun.cloud.shiro.service.query.SysUserRoleQUERY;
import sun.cloud.shiro.service.bo.SysUserRoleRemoveBO;
import sun.cloud.shiro.service.dto.SysUserRoleDTO;
import sun.cloud.shiro.service.bo.SysUserRoleUpdateBO;
import sun.cloud.core.base.Pagination;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface SysUserRoleService {


    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<SysUserRoleDTO> page(SysUserRoleQUERY bean);

    /**
     * 查询列表
     * @param bean  查询条件对象
     * @return   集合对象
     * */
    List<SysUserRoleDTO> list(SysUserRoleQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(SysUserRoleSaveBO bean);



    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(SysUserRoleRemoveBO bean);


}