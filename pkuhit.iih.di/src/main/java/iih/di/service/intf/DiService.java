/**
 * <p>文件名:		DiService.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package iih.di.service.intf;

import iih.di.model.CommitDataModel;
import iih.di.model.DibDiRtModel;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pkuhit.iih.di.DiagnosisModel;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

/**
 * <p>
 * DiService
 * </p>
 * <p>
 * TODO
 * </p>
 * 
 * @author 李德强(li_deqiang@founder.com, readwall@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李德强</td>
 *          <td>2014年8月28日 上午11:22:13</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public interface DiService {

	/**
	 * 获取诊断列表
	 * @param map
	 * @return
	 * testJson\01getDisByEnSn_01.js
	 */
	@RequestMapping("/di/{enSn}/dis")
	List<DibDiRtModel> getDisByEnSn(@PathVariable("enSn") String enSn, @RequestParam Map map);
	
	
	
	/**
	 * 保存诊断列表
	 * @param map
	 * @return
	 * testJson\02saveEns_01.js
	 */
	@RequestMapping(value = { "/di/ens" }, method = { RequestMethod.POST })
	Map saveEns(@ModelAttribute CommitDataModel commitDataModel) ;
	
	
	/**
	 * 删除enSn就诊的diCd诊断
	 * @param enSn  就诊序号
	 * @param diCd  诊断编码
	 * @return
	 * testJson\02saveEns_01.js
	 */
	@RequestMapping(value = { "/di/ens/del/{diSn}" }, method = { RequestMethod.DELETE })
	Map deleteDia(@PathVariable("diSn") String diSn, @RequestParam Map map) ;
	
	/**
	 * 诊断名称辅助录入
	 * @param keyword  关键字，可以是中文，可以是英文
	 * @return  20条  诊断名称、编码、icd
	 * testJson\03asistantInput_01.js
	 * */
	@RequestMapping("/di/asistantInput")
	Map Asistant(@RequestParam Map query) ;

	
	/**
	 * 获取enSn对应的诊断列表，并复制给newEnsn
	 * @param map
	 * @return
	 * 
	 */
	@RequestMapping("/di/copyLastDiAddCopyFlag")
	void saveCopyDisByEnSn(@RequestParam("enSn") String enSn, @RequestParam("newEnsn") String newEnsn) ;
	
	/**
	 * 获取有效的oldEnSn对应的病历文书列表及诊断，并复制给newEnsn
	 * @param map
	 * @return
	 */
	@RequestMapping("/di/mr/copy/{enSn}")
	void saveCopyDisAndMrsByEnSn(@PathVariable("enSn") String enSn) ;
	
	/**
	 * 获取oldEnSn对应的病历文书列表，并复制给newEnsn
	 * @param map
	 * @return
	 */
	void saveCopyMrsByEnSn(@RequestParam("oldEnSn") String oldEnSn,@RequestParam("newEnsn") String newEnsn) ;
	/**
	 * 获取诊断列表,给助手区使用
	 * @param map
	 * @return
	 * testJson\01getDisByEnSn_01.js
	 */
	@RequestMapping("/di/list/{enSn}")
	ArrayResult<DiagnosisModel> getDisListByEnSn(@PathVariable("enSn") String enSn, @RequestParam Map map);
}
