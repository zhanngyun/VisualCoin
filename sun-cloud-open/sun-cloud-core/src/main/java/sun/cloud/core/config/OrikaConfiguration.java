package sun.cloud.core.config;

import org.springframework.context.annotation.Configuration;
import sun.cloud.core.orika.OrikaBeanMapper;
import org.springframework.context.annotation.Bean;

/**
 * @Author: yzhang
 * @Date: 2018/4/14 19:02
 * @Desc: Orika的配置文件
 */
@Configuration
public class OrikaConfiguration {

    public OrikaConfiguration() {
    }

    @Bean
    public OrikaBeanMapper beanMapper() {
        return new OrikaBeanMapper();
    }
}
