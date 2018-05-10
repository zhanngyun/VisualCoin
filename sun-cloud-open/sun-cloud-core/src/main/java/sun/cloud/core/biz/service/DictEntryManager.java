
package sun.cloud.core.biz.service;


import sun.cloud.core.base.Pagination;
import sun.cloud.core.biz.service.bo.DictEntryRemoveBO;
import sun.cloud.core.biz.service.bo.DictEntrySaveBO;
import sun.cloud.core.biz.service.bo.DictEntryUpdateBO;
import sun.cloud.core.biz.service.dto.DictEntryDTO;
import sun.cloud.core.biz.service.query.DictEntryQUERY;

public interface DictEntryManager {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
     */
    DictEntryDTO get(Long id);

    /**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */
    Pagination<DictEntryDTO> list(DictEntryQUERY bean);

    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(DictEntrySaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数
     */
    Integer doUpdate(DictEntryUpdateBO bean);

    /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数
     */
    Integer doRemove(DictEntryRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数
     */
    Integer doRemove(Long id);

}