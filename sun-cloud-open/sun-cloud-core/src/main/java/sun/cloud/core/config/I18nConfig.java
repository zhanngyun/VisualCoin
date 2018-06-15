package sun.cloud.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.util.Locale;

/**
 * @Author: yzhang
 * @Date: 2018/6/5 16:48
 * @Desc: 项目支持国际化操作
 */
@Configuration
public class I18nConfig {

    private static Logger logger = LoggerFactory.getLogger(I18nConfig.class);

    @Bean
    public SunCloudLocaleResolver localeResolver() {
        logger.info("使用自定义国际化");
        SunCloudLocaleResolver slr = new SunCloudLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    public ResourceBundleMessageSource getMessageSource() throws Exception {
        ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
        rbms.setDefaultEncoding("UTF-8");
        rbms.setBasenames("i18n/messages");
        return rbms;
    }


    @Bean
    public Validator validator() throws Exception{
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(getMessageSource());
        return validator;
    }

    class SunCloudLocaleResolver extends AcceptHeaderLocaleResolver {
        private Locale locale;

        @Override
        public Locale resolveLocale(HttpServletRequest request) {

            return locale == null ? request.getLocale() : this.locale;
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
            this.locale = locale;
        }
    }



}



