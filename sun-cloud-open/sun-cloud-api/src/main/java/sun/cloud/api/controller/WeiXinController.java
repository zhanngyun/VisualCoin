package sun.cloud.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

   /* @Autowired
    private DictEntryMapper dictEntryMapper;*/

    @RequestMapping(method = RequestMethod.GET)
    public void authGet(
            @RequestParam(name = "signature",
                    required = false) String signature,
            @RequestParam(name = "timestamp",
                    required = false) String timestamp,
            @RequestParam(name = "nonce", required = false) String nonce,
            @RequestParam(name = "echostr", required = false) String echostr, HttpServletResponse response) {

        this.logger.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature,
                timestamp, nonce, echostr);

        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.write(echostr);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != out) {
                    out.close();
                }
            }
    }


    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public ResponseModel<UserInfo> getCode(@RequestParam("code") String code, HttpServletResponse response) throws IOException {

//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxcb333f3b69e13e61&secret=bd31744daacf03d2f6918c76e31884f8&code="+code+"&grant_type=authorization_code";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx4dda544bc4e0c910&secret=4fec7afdaf39a8e8ff29de1eecdeffcc&js_code="+code+"&grant_type=authorization_code";
        String responseMsg = restTemplate(url, null, String.class, HttpMethod.GET);
        System.out.println("获取token信息"+responseMsg);
        Map<String, Object> map = JacksonUtils.json2Map(responseMsg);
//        JacksonUtils.toJsonString("{openid:"+map.get("openid")+",session_key:"+map.get("session_key")+"}");

        System.out.println("用户的OpenId为："+map.get("openid")+"用户的sessionKey为："+map.get("session_key"));
//        String userInfo = "https://api.weixin.qq.com/sns/userinfo?access_token="+map.get("session_key")+"&openid="+map.get("openid")+"&lang=zh_CN";
//        String userInfoMessage = restTemplate(userInfo, null, String.class, HttpMethod.GET);
//        System.out.println("获取用户信息"+userInfoMessage);
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenid((String)map.get("openid"));
        return success(userInfo);

    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseModel<String> save(UserInfo userInfo){
        System.out.println(userInfo.toString());
        return success("true");
    }

    public <T> T restTemplate(String url, Map<String,T> params, Class<T> var, HttpMethod method) {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> converterList=restTemplate.getMessageConverters();
        CustomizeStringHttpMessageConverter converter = new CustomizeStringHttpMessageConverter();
        converterList.add(0, converter);
        restTemplate.setMessageConverters(converterList);
       return restTemplate.getForObject(url, var);
    }

}
