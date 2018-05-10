package sun.cloud.core.dictionary.cache;

import sun.cloud.core.dictionary.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/1/18.
 */

public class HashMapDictCache implements IDictCache {

    private IDictCache dictCache;

    private static final Map<String,List<Item>> cache = new HashMap<>();

    /**
     * 更新时间
     */
    private static final Map<String,Long> updateTime = new HashMap<>();

    /**
     * 每2小时检查一次
     */
    private static Long expireTime = 2*3600*1000L;

    @Override
    public List<Item> getEntry(String entryCode) {
        if(expire(entryCode) || cache.get(entryCode) == null){ //过期 或为null
            List<Item> list = dictCache.getEntry(entryCode);
            if(null != list && !list.isEmpty()){
                updateTime.put(entryCode,System.currentTimeMillis());
                cache.put(entryCode,list);
            }
        }
        return cache.get(entryCode);
    }

    private Boolean expire(String entryCode){
        Long upTime = updateTime.get(entryCode);
        // null 和过期
        return (upTime == null ) || ( upTime != null && (upTime + expireTime) < System.currentTimeMillis());
    }

    /**
     * 失效
     *
     * @param entryCode
     */
    @Override
    public void clear(String entryCode) {
        cache.remove(entryCode);
        dictCache.clear(entryCode);
    }

    public IDictCache getDictCache() {
        return dictCache;
    }

    public void setDictCache(IDictCache dictCache) {
        this.dictCache = dictCache;
    }
}
