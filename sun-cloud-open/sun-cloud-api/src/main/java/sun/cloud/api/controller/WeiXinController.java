package sun.cloud.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.cloud.api.constants.CustomizeStringHttpMessageConverter;
import sun.cloud.api.query.UserInfo;
import sun.cloud.core.base.BaseController;
import sun.cloud.core.base.ResponseModel;
import sun.cloud.core.utils.JacksonUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @Author: yzhang
 * @Date: 2018/4/20 16:59
 * @Desc:
 */
@RestController
@RequestMapping("/weixin")
public class WeiXinController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(WeiXinController.class);

    @Value("{weixin.url}")
    private String weixinUrl;

    /**
     * 用户信息认证
     * @param code 微信code
     * @return 返回UserInfo
     */
    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public ResponseModel<UserInfo> getCode(@RequestParam("code") String code) {
        String url = weixinUrl;
        String responseMsg = restTemplate(url, null, String.class, HttpMethod.GET);
        System.out.println("获取token信息"+responseMsg);
        Map<String, Object> map = JacksonUtils.json2Map(responseMsg);
        System.out.println("用户的OpenId为："+map.get("openid")+"用户的sessionKey为："+map.get("session_key"));
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenid((String)map.get("openid"));
        return success(userInfo);

    }

    /**
     * 用户信息注册
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseModel<String> save(UserInfo userInfo){
        System.out.println("保存用户信息："+userInfo.toString());
        return success("true");
    }


    /**
     * 使用restTemplate调用外部
     * @param url
     * @param params
     * @param var
     * @param method
     * @param <T>
     * @return
     */
    public <T> T restTemplate(String url, Map<String,T> params, Class<T> var, HttpMethod method) {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> converterList=restTemplate.getMessageConverters();
        CustomizeStringHttpMessageConverter converter = new CustomizeStringHttpMessageConverter();
        converterList.add(0, converter);
        restTemplate.setMessageConverters(converterList);
       return restTemplate.getForObject(url, var);
    }

}
