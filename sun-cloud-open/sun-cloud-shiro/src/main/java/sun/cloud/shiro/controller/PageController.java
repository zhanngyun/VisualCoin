package sun.cloud.shiro.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 16:41
 * @Desc:
 */
public class PageController {

    @RequestMapping("/**/*.html")
    public String forward(HttpServletRequest request){
        String uri = WebUtils.getRequestUri(request).replace((String)request.getServletContext().getAttribute("resRoot"),"");
        return StringUtils.substring(uri,1,uri.lastIndexOf(".html"));
    }

    /**
     * 特殊处理登录页
     * @return
     */
    @RequestMapping(value = "/login")
    public String forward(){
        return "login";
    }
}
