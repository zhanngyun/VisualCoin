
package sun.cloud.shiro.service;
import java.util.List;
import sun.cloud.shiro.service.bo.SysRoleMenuSaveBO;
import sun.cloud.shiro.service.query.SysRoleMenuQUERY;
import sun.cloud.shiro.service.bo.SysRoleMenuRemoveBO;
import sun.cloud.shiro.service.dto.SysRoleMenuDTO;
import sun.cloud.shiro.service.bo.SysRoleMenuUpdateBO;
import sun.cloud.core.base.Pagination;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface SysRoleMenuService {


    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<SysRoleMenuDTO> page(SysRoleMenuQUERY bean);

    /**
     * 查询列表
     * @param bean  查询条件对象
     * @return   集合对象
     * */
    List<SysRoleMenuDTO> list(SysRoleMenuQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(SysRoleMenuSaveBO bean);


    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(SysRoleMenuRemoveBO bean);


}