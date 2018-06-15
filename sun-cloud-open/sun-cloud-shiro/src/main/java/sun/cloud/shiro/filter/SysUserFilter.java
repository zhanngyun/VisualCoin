package sun.cloud.shiro.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import sun.cloud.shiro.domain.ShiroUser;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 15:21
 * @Desc:
 */
public class SysUserFilter extends PathMatchingFilter {
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("user", user);
        return true;
    }
}
