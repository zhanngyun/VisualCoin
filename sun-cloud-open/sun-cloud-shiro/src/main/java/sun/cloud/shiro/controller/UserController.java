package sun.cloud.shiro.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.cloud.core.base.BaseController;
import sun.cloud.core.base.ResponseModel;
import sun.cloud.shiro.domain.ShiroUser;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yzhang
 * @Date: 2018/6/15 15:51
 * @Desc: 系统用户控制器
 */
@RestController
public class UserController extends BaseController {

    /**
     * 登录方法
     *
     * @param shiroUser
     * @return
     */
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<String> ajaxLogin(ShiroUser shiroUser) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(shiroUser.getUserName(), shiroUser.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success(jsonObject.toString());
    }


}
