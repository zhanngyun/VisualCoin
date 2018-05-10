package sun.cloud.core.biz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.cloud.core.base.Pagination;
import sun.cloud.core.biz.domain.DictEntryDO;
import sun.cloud.core.biz.domain.DictEntryMapper;
import sun.cloud.core.biz.service.DictEntryManager;
import sun.cloud.core.biz.service.DictItemManager;
import sun.cloud.core.biz.service.bo.DictEntryRemoveBO;
import sun.cloud.core.biz.service.bo.DictEntrySaveBO;
import sun.cloud.core.biz.service.bo.DictEntryUpdateBO;
import sun.cloud.core.biz.service.bo.DictItemRemoveBO;
import sun.cloud.core.biz.service.dto.DictEntryDTO;
import sun.cloud.core.biz.service.query.DictEntryQUERY;
import sun.cloud.core.orika.OrikaBeanMapper;

import java.util.Date;
import java.util.List;

@Service
public class DictEntryManagerImpl implements DictEntryManager {

    @Autowired
    private DictEntryMapper dictEntryMapper;

    @Autowired
    private DictItemManager dictItemManager;

    @Autowired
    private OrikaBeanMapper beanMapper;


    @Override
    public DictEntryDTO get(Long id){
        return beanMapper.map(dictEntryMapper.get(id),DictEntryDTO.class);
    }


    @Override
    public Pagination<DictEntryDTO> list(DictEntryQUERY bean){
        PageHelper.startPage(bean.getPage(), bean.getPageSize());
        Page<DictEntryDO> dictEntry = (Page<DictEntryDO>)dictEntryMapper.list(beanMapper.map(bean,DictEntryDO.class));
        Pagination<DictEntryDTO> result = new Pagination<>();
        result.setData(beanMapper.mapAsList(dictEntry, DictEntryDTO.class));
        result.setTotal(dictEntry.getTotal());
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long doSave(DictEntrySaveBO bean){
        DictEntryDO DictEntry = beanMapper.map(bean, DictEntryDO.class);
        DictEntry.setGmtCreate(new Date());
        //dictEntryMapper.save(DictEntry);
        return DictEntry.getId();
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doUpdate(DictEntryUpdateBO bean){
        DictEntryDO DictEntry = beanMapper.map(bean, DictEntryDO.class);
        DictEntry.setGmtModified(new Date());
      //  return dictEntryMapper.update(DictEntry);
        return 11;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(DictEntryRemoveBO bean){
        DictEntryDO DictEntry = beanMapper.map(bean, DictEntryDO.class);
        List<DictEntryDO> items =  null;//dictEntryMapper.list(DictEntry);
        items.stream().forEach(entry -> doRemove(entry.getId()));
        return  items.size();
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer doRemove(Long id){
        //需要同步删除 字典项下的字典
        DictItemRemoveBO bean = new DictItemRemoveBO();
        bean.setEntryId(String.valueOf(id));
       // dictItemManager.doRemove(bean);
        /*DictEntryDO entryDO = dictEntryMapper.get(id);
        if(null != entryDO){
            DictManager.clear(entryDO.getEntryCode());
        }
        Integer count = dictEntryMapper.delete(id);*/
        return 11;//count;
    }
}
