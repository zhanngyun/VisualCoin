package sun.cloud.core.dictionary;


import org.springframework.beans.factory.annotation.Autowired;
import sun.cloud.core.base.Pagination;
import sun.cloud.core.biz.service.DictItemManager;
import sun.cloud.core.biz.service.dto.DictItemDTO;
import sun.cloud.core.biz.service.query.DictItemQUERY;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 继承AbstractDictLoader,实现数据字典的加载
 */
public class DBDictionaryLoader extends AbstractDictLoader {

    @Autowired
    private DictItemManager manager;
    /**
     * 加载数据字典条目
     *
     * @create: 2014-4-8 下午3:46:33 xuebj07252
     * @history:
     */
    @Override
    protected void loadDictItems() {

    }

    /**
     * 获取数据字典项
     *
     * @param entryCode
     * @return
     * @create: 2014-4-8 下午3:43:39 xuebj07252
     * @history:
     */
    @Override
    public List<Item> getItem(String entryCode) {
        DictItemQUERY bean = new DictItemQUERY();
        bean.setEntryCode(entryCode);
        Pagination<DictItemDTO> list = manager.list(bean);
        return list.getData().stream().map(dictItem -> {
            Item item = new Item();
            item.setEntryCode(dictItem.getEntryCode());
            item.setItemCode(dictItem.getItemCode());
            item.setItemName(dictItem.getItemName());
            item.setItemOrder((long)dictItem.getItemOrder());
            return item;
        }).collect(Collectors.toList());
    }
}
