package sun.cloud.shiro.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import sun.cloud.core.utils.AJAXUtils;
import sun.cloud.shiro.domain.ShiroUser;
import sun.cloud.shiro.realm.ForbiddenException;
import sun.cloud.shiro.realm.ShiroUserUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 14:52
 * @Desc: shiro自定义表单验证
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    private Boolean alwaysToSuccessUrl = Boolean.FALSE;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        if (subject.isAuthenticated()) {//已经登录
            if (isLoginRequest(request, response)) {//登录请求，允许用户在同一会话期间重复登录
                return false;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        if (AJAXUtils.isAjax(WebUtils.toHttp(request))) {//ajax
            ShiroUser user = ShiroUserUtils.toUser(subject.getPrincipal());
            AJAXUtils.print(WebUtils.toHttp(response), 200, user.getUserName());
            return false;
        }
        if (alwaysToSuccessUrl) {
            String successUrl = this.getSuccessUrl();
            if (successUrl == null) {
                throw new IllegalStateException("Success URL not available via saved request or via the " +
                        "successUrlFallback method parameter. One of these must be non-null for " +
                        "issueSuccessRedirect() to work.");
            }
            WebUtils.issueRedirect(request, response, successUrl, null, true);
            return false;
        } else {
            return super.onLoginSuccess(token, subject, request, response);
        }
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        String msg;
        if (!(e instanceof ForbiddenException)) {
            msg = "用户名或者密码错误";
        } else {
            msg = e.getMessage();
        }
        if (AJAXUtils.isAjax((HttpServletRequest) request)) {//ajax
            AJAXUtils.print((HttpServletResponse) response, 401, msg);
            return false;
        } else {
            request.setAttribute(getFailureKeyAttribute(), msg);
            return true;
        }
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (request.getAttribute(getFailureKeyAttribute()) != null) {
            return true;
        }
        return super.onAccessDenied(request, response);
    }

    /**
     * 登录成功之后是否总是跳转到成功页
     *
     * @param alwaysToSuccessUrl
     */
    public void setAlwaysToSuccessUrl(Boolean alwaysToSuccessUrl) {
        this.alwaysToSuccessUrl = alwaysToSuccessUrl;
    }
}
