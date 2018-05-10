package sun.cloud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.cloud.api.controller.vo.DictEntryVO;
import sun.cloud.core.base.BaseController;
import sun.cloud.core.base.Pagination;
import sun.cloud.core.base.ResponseModel;
import sun.cloud.core.biz.service.DictEntryManager;
import sun.cloud.core.biz.service.dto.DictEntryDTO;
import sun.cloud.core.biz.service.query.DictEntryQUERY;
import sun.cloud.core.dictionary.DictManager;
import sun.cloud.core.orika.OrikaBeanMapper;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yzhang
 * @Date: 2018/4/15 22:27
 * @Desc:  数据字典
 */
@RestController
@RequestMapping("/dict_manager")
public class DictEntryController extends BaseController{


    @Autowired
    private DictEntryManager dictEntryManager;

    @Autowired
    private OrikaBeanMapper beanMapper;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseModel<DictEntryVO> get(@RequestParam("id") Long id){

        DictEntryDTO dictEntryDTO = dictEntryManager.get(id);
        DictEntryVO entryVO = beanMapper.map(dictEntryDTO, DictEntryVO.class);
        Cache hh = cacheManager.getCache("hh");

        return success(entryVO);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseModel<Pagination<DictEntryDTO>> list(HttpServletRequest request){
        String callback = request.getParameter("callback");
        return success(dictEntryManager.list(new DictEntryQUERY()));
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletRequest request){
        String callback = request.getParameter("callback");
        return callback+"{\"username\":\"张云\"}";
    }

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public void getCode(@RequestParam("code") String code){

        System.out.println("进来了。。。");
        System.out.println(code);
    }




}
