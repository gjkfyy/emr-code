/**
 * 
 */
package ei.zy.en.service;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.Amr;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 *
 */
public interface EiEncounterService {
	/**
	 * 根据就诊序号，插入到数据库
	 * @param enTypeCode 就诊类型
	 * @return Map
	 * http://localhost:8081/ei/updateencounter/838535?xmode=debug
	 * */
	//@RequestMapping("/enDetail/{enSn}")
	@RequestMapping(value = "ei/insertencounter/{enPk}", method = RequestMethod.GET)
	SingleResult<Map> insertEncounterToDB(@PathVariable("enPk") String enPk,@RequestParam Map map);
	
	
	/**
	 * 根据就诊序号，更新到数据库
	 * @param enTypeCode 就诊类型
	 * @return Map
	 * http://localhost:8081/ei/updateencounter/838535?xmode=debug
	 * */
	@RequestMapping(value = "ei/updateencounter/{enPk}", method = RequestMethod.GET)
	SingleResult<Map> updateEncounterToDB(@PathVariable("enPk") String enPk,@RequestParam Map map);
	
	/**
	 *  将某个表数据导入本系统库（nis_ward_config）
	 * @return boolean
	 *
	 */
	@RequestMapping(value = "/ei/ob/importNisWardConfig", method = RequestMethod.GET)
	SingleResult<String>  importNisWardConfig();
}
