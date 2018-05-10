package sun.cloud.core.dictionary.cache;

import sun.cloud.core.dictionary.DictionaryServiceImpl;
import sun.cloud.core.dictionary.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xuebj on 2017/6/13.
 */
@Component
public class RedisDictCache implements IDictCache{

    @Autowired
    private DictionaryServiceImpl dictionaryServiceImpl;


    @Cacheable(value = "data", key = "'dict_' + #entryCode")
    @Override
    public List<Item> getEntry(String entryCode) {
        return dictionaryServiceImpl.getEntry(entryCode);
    }

    @CacheEvict(value = "data", key = "'dict_' + #entryCode",allEntries = true)
    @Override
    public void clear(String entryCode) {

    }
}
