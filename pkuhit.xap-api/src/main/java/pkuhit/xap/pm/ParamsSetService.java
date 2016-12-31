package pkuhit.xap.pm;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xap.sv.annotation.Service;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

@Service
public interface ParamsSetService
{
    /**
     * 
     * @description 创建
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:47:49
     * @param Param
     * @return
     */
    @RequestMapping(value = "/param/set/create", method = RequestMethod.POST)
    Param create(@ModelAttribute Param param);
    /**
     * 
     * @description 更新
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:48:01
     * @param Param
     * @return
     */
    @RequestMapping(value = "/param/set/update/{id}", method = RequestMethod.PUT)
    SingleResult<Param> update(@PathVariable("id") String ParamCd, @ModelAttribute Param param);
    /**
     * 
     * @description 删除
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:48:01
     * @param Param
     * @return
     */
    @RequestMapping(value = "/param/set/delete/{id}", method = RequestMethod.DELETE)
    SingleResult<Param> delete(@PathVariable("id") String ParamCd, @ModelAttribute Param param)throws Throwable;
    /**
     * 
     * @description 查询单个
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:48:01
     * @param Param
     * @return
     */
    @RequestMapping(value = "/param/set/one/{id}", method = RequestMethod.GET)
    SingleResult<Param> selectById(@PathVariable("id") String ParamCd);
    
    /**
     * map中key值：
     * @description 查询
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:42:06
     * @param params
     * @return
     */
    @RequestMapping(value = "/param/set/list", method = RequestMethod.GET)
    ArrayResult<Param> search(@RequestParam Map<String, String> params);
    
    /**
     * 
     * @description 验证
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:48:01
     * @param Param
     * @return
     */
    @RequestMapping(value = "/param/set/check", method = RequestMethod.GET)
    SingleResult<Map> findByNm(@RequestParam  Map<String, String> params) throws IOException;
    
    /**
     * map中key值：
     * @description 查询
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:42:06
     * @param params
     * @return
     */
    @RequestMapping(value = "/param/set/bycode", method = RequestMethod.GET)
    SingleResult<Map> searchByCode(@RequestParam String code);
    
    /**
     * 查询功能开关
     * 获取Code为 SYSM01.0'的 Key（如：ORDER_READ_FROM_VIEW）对应的value值   
     * @description 查询
     * @author guo_zhongbao
     * @date 2015年10月23日 上午10:42:06
     * @param key ： 开关的key值。如   OB_READ_FROM_VIEW
     * @return 返回 key对应的value值
     */
    @RequestMapping(value = "/param/set/getflagbykey", method = RequestMethod.GET)
    SingleResult<String> searchFunFlagByKey(@RequestParam("key") String key);
    
    /**
     * 
     * @description 创建
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:47:49
     * @param Param
     * @return
     */
    @RequestMapping(value = "/param/set/keyword", method = RequestMethod.GET)
    ArrayResult<Param> searchByKeyword(@RequestParam  Map<String, String> params);
    
    /**
     * map中key值：
     * @description 加载到内存中
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:42:06
     * @param params
     * @return
     */
    @RequestMapping(value = "/param/set/refresh", method = RequestMethod.GET)
    ArrayResult<Param> refresh(@RequestParam Map<String, String> params);
}
