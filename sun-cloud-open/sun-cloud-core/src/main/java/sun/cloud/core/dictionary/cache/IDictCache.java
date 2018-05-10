package sun.cloud.core.dictionary.cache;

import sun.cloud.core.dictionary.Item;

import java.util.List;

/**
 * Created by xuebj on 2017/1/18.
 */
public interface IDictCache {




    /**
     * 获取
     * @param entryCode
     */
    List<Item>  getEntry(String entryCode);

    /**
     * 失效
     * @param entryCode
     */
    void clear(String entryCode);
}
