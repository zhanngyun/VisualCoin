package sun.cloud.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @Author: yzhang
 * @Date: 2018/6/6 9:36
 * @Desc: 国际化插件使用
 */
@Component
public class I18nHelper {

    @Autowired
    private  MessageSource messageSource;


    public  <T> T getMessage(String code,Object...args){
        return (T)messageSource.getMessage(code,args, LocaleContextHolder.getLocale());
    }
}
