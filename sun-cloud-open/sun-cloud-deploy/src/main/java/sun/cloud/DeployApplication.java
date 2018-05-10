package sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Author: yzhang
 * @Date: 2018/4/15 21:56
 * @Desc:
 */

@SpringBootApplication
public class DeployApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class,args);
    }


    /**
     * 如果需要把应用部署到容器(如tomcat),使用
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DeployApplication.class);
    }


    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
    }
}
