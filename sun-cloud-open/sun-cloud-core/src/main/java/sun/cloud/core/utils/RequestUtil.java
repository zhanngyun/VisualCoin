package sun.cloud.core.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static sun.cloud.core.utils.HttpRequestConstants.*;

/**
 * request 相关工具类
 * Created by xuebojie on 16/5/6.
 */
public class RequestUtil {

    /**
     *  判断是否是ajax请求,首先判断是否是否isAjax 参数 为true
     *  request的 accept 包含 application/json 说明返回json格式数据 表示Ajax请求
     *  X-Requested-With 包含 XMLHttpRequest
     * @return 如果是Ajax请求返回true 否则返回false
     */
    public static Boolean isAjaxRequest(HttpServletRequest request){
        return isAjax(request)? Boolean.TRUE: StringUtils.contains(request.getHeader(HEADER_ACCEPT),HEADER_ACCEPT_JSON) ||
               StringUtils.contains(request.getHeader(HEADER_XREQUESTEDWITH),HEADER_XREQUESTEDWITH_XMLHTTPREQUEST);
    }


    private static Boolean isAjax(HttpServletRequest request){
        String isAjax = request.getParameter("isAjax");
        return StringUtils.equalsIgnoreCase("true",isAjax);
    }

    /**
     * 获取客户端IP地址
     * @param request
     * @return
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
