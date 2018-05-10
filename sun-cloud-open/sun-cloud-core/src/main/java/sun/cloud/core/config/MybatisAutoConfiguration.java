package sun.cloud.core.config;

import sun.cloud.core.proprties.MyBatiesProperties;
import com.github.pagehelper.PageHelper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: yzhang
 * @Date: 2018/4/15 18:43
 * @Desc: mybatis的配置pageHelper，使其在mybatis中生效
 */
@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties({MyBatiesProperties.class})
public class MybatisAutoConfiguration {


    @Bean
    public PageHelper pageHelper(MyBatiesProperties pageHelperProperties) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.setProperties(pageHelperProperties.getProperties());
        return pageHelper;
    }

}
