package sun.cloud.core.biz.service.impl;


import sun.cloud.core.base.Pagination;
import sun.cloud.core.biz.domain.DictItemDO;
import sun.cloud.core.biz.domain.DictItemMapper;
import sun.cloud.core.biz.service.DictItemManager;
import sun.cloud.core.biz.service.bo.DictItemRemoveBO;
import sun.cloud.core.biz.service.bo.DictItemSaveBO;
import sun.cloud.core.biz.service.bo.DictItemUpdateBO;
import sun.cloud.core.biz.service.dto.DictItemDTO;
import sun.cloud.core.biz.service.query.DictItemQUERY;
import sun.cloud.core.dictionary.DictManager;
import sun.cloud.core.orika.OrikaBeanMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Service
public class DictItemManagerImpl implements DictItemManager {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DictItemMapper dictItemMapper;

    
    @Autowired
    private OrikaBeanMapper beanMapper;


/**
     * 获取单个对象
     * @param id    主键
     * @return 结果对象
*/



    @Override
    public DictItemDTO get(Long id){
        return beanMapper.map(dictItemMapper.get(id),DictItemDTO.class);
    }


/**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
*/


    @Override
    public Pagination<DictItemDTO> page(DictItemQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<DictItemDO> DictItem = (Page<DictItemDO>) dictItemMapper.list(beanMapper.map(bean, DictItemDO.class));
        Pagination<DictItemDTO> result = new Pagination<>();
        result.setData(beanMapper.mapAsList(DictItem, DictItemDTO.class));
        result.setTotal(DictItem.getTotal());
        return result;
    }


/**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */

    @Override
    public Pagination<DictItemDTO> list(DictItemQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<DictItemDO> DictItem = (Page<DictItemDO>) dictItemMapper.list(beanMapper.map(bean, DictItemDO.class));
        Pagination<DictItemDTO> result = new Pagination<>();
        result.setData(beanMapper.mapAsList(DictItem, DictItemDTO.class));
        result.setTotal(DictItem.getTotal());
        return result;
    }


/**
     * 查询对象列表
     * @param bean  查询条件对象
     * @return  分页对象
     */

    @Override
    public List<DictItemDTO> listItem(DictItemQUERY bean){
       return beanMapper.mapAsList(dictItemMapper.list(beanMapper.map(bean, DictItemDO.class)),DictItemDTO.class);
    }


/**
     * 根据字典查询字典条目
     *
     * @param entryCodesList
     * @return*/


    @Override
    public Map<String, List<DictItemDTO>> list(List<String> entryCodesList) {
        Map<String,List<DictItemDTO>> result = new HashMap<>();
        entryCodesList.stream().forEach(entryCode ->
            result.put(entryCode,beanMapper.mapAsList(dictItemMapper.list(new DictItemDO(entryCode)),DictItemDTO.class))
        );
        return result;
    }


/**
     * 保存单个对象,返回主键
     * @param bean  保存对象
     * @return 主键*/


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(DictItemSaveBO bean){
        DictItemDO DictItem = beanMapper.map(bean, DictItemDO.class);
        DictItem.setGmtCreate(new Date());
        dictItemMapper.save(DictItem);
        DictManager.clear(bean.getEntryCode());
        return DictItem.getId();
    }


/**
     * 更新单个对象 id必须有
     * @param bean  更新对象
     * @return 更新的记录条数*/


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(DictItemUpdateBO bean){
        DictItemDO DictItem = beanMapper.map(bean, DictItemDO.class);
        DictItem.setGmtModified(new Date());
        DictItemDO DictItemDO = dictItemMapper.get(bean.getId());
        DictManager.clear(DictItemDO.getEntryCode());
        return dictItemMapper.update(DictItem);
    }


/**
     * 按条件删除对象
     * @param bean  条件对象
     * @return  删除的记录条数*/


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(DictItemRemoveBO bean){
        DictItemDO DictItem = beanMapper.map(bean, DictItemDO.class);
        List<DictItemDO> lists =  dictItemMapper.list(DictItem);
        lists.stream().forEach(item -> DictManager.clear(item.getEntryCode()));
        return dictItemMapper.remove(DictItem);
    }


/**
     * 按主键删除对象
     * @param id    主键
     * @return 删除的记录条数*/



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        DictItemDO DictItemDO  = dictItemMapper.get(id);
        if(null != DictItemDO){
            DictManager.clear(DictItemDO.getEntryCode());
        }
        return dictItemMapper.delete(id);
    }

}
