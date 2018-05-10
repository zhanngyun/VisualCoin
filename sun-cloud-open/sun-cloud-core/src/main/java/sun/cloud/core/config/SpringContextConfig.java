package sun.cloud.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.cloud.core.biz.service.DictItemManager;
import sun.cloud.core.dictionary.DBDictionaryLoader;

/**
 * spring 全局的bean
 */
@Configuration
public class SpringContextConfig {

    /**
     * 数据字典加载类
     *
     * @param manager
     * @return
     */
    @Bean
    public DBDictionaryLoader dictionaryLoader(DictItemManager manager) {
        DBDictionaryLoader loader = new DBDictionaryLoader();
        return loader;
    }
}
