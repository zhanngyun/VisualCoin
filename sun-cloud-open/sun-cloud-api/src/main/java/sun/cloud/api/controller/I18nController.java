package sun.cloud.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import sun.cloud.api.query.UserInfo;
import sun.cloud.core.config.I18nHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;

/**
 * @Author: yzhang
 * @Date: 2018/6/5 17:03
 * @Desc:
 */
@RestController
public class I18nController {
    private static final Logger logger = LoggerFactory.getLogger(I18nController.class);

    @Autowired
    private I18nHelper i18nHelper;


    @GetMapping("/welcome")
    public String welcome() {
        return (String) i18nHelper.getMessage("welcome",null);
    }

    @GetMapping("/language")
    public ModelAndView language(HttpServletRequest request, HttpServletResponse response, String language) {
        Locale locale = request.getLocale();
        logger.error(locale.toString());
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        language = language.toLowerCase();
        logger.info("language:" + language);
        if (language == null || language.equals("")) {
            return new ModelAndView("welcome");
        } else {
            if (language.equals("zh_cn")) {
                localeResolver.setLocale(request, response, Locale.CHINA);
            } else if (language.equals("en_us")) {
                localeResolver.setLocale(request, response, Locale.US);
            } else {
                localeResolver.setLocale(request, response, Locale.CHINA);
            }
        }
        return new ModelAndView("redirect:welcome");
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(@Valid UserInfo userInfo){
        return "success";
    }
}
