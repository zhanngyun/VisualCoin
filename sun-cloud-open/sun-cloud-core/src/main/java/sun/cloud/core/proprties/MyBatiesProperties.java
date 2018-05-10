package sun.cloud.core.proprties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * @Author: yzhang
 * @Date: 2018/4/15 18:32
 * @Desc: Mybaties的配置类
 */
@ConfigurationProperties(prefix = "sunCloud.mybatis.plugin.pagehelper")
public class MyBatiesProperties {

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
