
package sun.cloud.shiro.service;
import java.util.List;
import sun.cloud.shiro.service.bo.SysMenuSaveBO;
import sun.cloud.shiro.service.query.SysMenuQUERY;
import sun.cloud.shiro.service.bo.SysMenuRemoveBO;
import sun.cloud.shiro.service.dto.SysMenuDTO;
import sun.cloud.shiro.service.bo.SysMenuUpdateBO;
import sun.cloud.core.base.Pagination;

/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public interface SysMenuService {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    SysMenuDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<SysMenuDTO> page(SysMenuQUERY bean);

    /**
     * 查询列表
     * @param bean  查询条件对象
     * @return   集合对象
     * */
    List<SysMenuDTO> list(SysMenuQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(SysMenuSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(SysMenuUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(SysMenuRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}