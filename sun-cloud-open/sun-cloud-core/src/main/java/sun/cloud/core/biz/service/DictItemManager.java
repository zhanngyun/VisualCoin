
package sun.cloud.core.biz.service;

import sun.cloud.core.base.Pagination;
import sun.cloud.core.biz.service.bo.DictItemRemoveBO;
import sun.cloud.core.biz.service.bo.DictItemSaveBO;
import sun.cloud.core.biz.service.bo.DictItemUpdateBO;
import sun.cloud.core.biz.service.dto.DictItemDTO;
import sun.cloud.core.biz.service.query.DictItemQUERY;

import java.util.List;
import java.util.Map;



public interface DictItemManager {

    /**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象*/

    DictItemDTO get(Long id);

    /**
     * 查询对象列表s
     * @param bean  查询条件对象
     * @return  分页对象*/

    Pagination<DictItemDTO> page(DictItemQUERY bean);

    Pagination<DictItemDTO> list(DictItemQUERY bean);

    /**
     * 查询
     * @param bean
     * @return*/

    List<DictItemDTO> listItem(DictItemQUERY bean);

    /**
     * 根据字典查询字典条目
     * @param entryCodesList
     * @return*/

    Map<String,List<DictItemDTO>> list(List<String> entryCodesList);


    /**
     * 保存单个对象
     * @param bean  保存对象
     * @return 主键
     */
    Long doSave(DictItemSaveBO bean);

    /**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数*/

    Integer doUpdate(DictItemUpdateBO bean);

   /**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数*/

    Integer doRemove(DictItemRemoveBO bean);

    /**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数*/

    Integer doRemove(Long id);

}