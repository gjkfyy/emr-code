/**
 * <p>文件名:		KrService.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package iih.kr.service.intf;

import iih.kr.model.DbDateModel;
import iih.kr.model.Dept;
import iih.kr.model.DiSuiteCommitModel;
import iih.kr.model.DiSuiteTreeNodeModel;
import iih.kr.model.DiSuiteTypeCommitModel;
import iih.kr.model.DiSuiteTypeModel;
import iih.kr.model.DiSuiteViewModel;
import iih.kr.model.RelDiModelSimple;
import iih.kr.model.RelMrTemplateModelSimple;
import iih.kr.model.ShareDeptModel;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

/**
 * <p>
 * KrService
 * @author guo_zhongbao(guo_zhongbao@founder.com)
 * @version 0.0.0
 */
public interface KrService {

	
	/**
	 * 获取组套列表,医生前端使用
	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	 * @param enTypeCode 就诊类型
	 * @return 数组  diName:'诊断名称',diCode:'诊断编码',ownerType:'所属类型',ownerCode:'所属编码',orgCode:'组织类型',diSuiteTypeCode:'自定义分类编码',diSuiteTypeName:'自定义分类名称',diSuiteCode :'组套编码',id:'索引值',text:'显示值'
	 */
	@RequestMapping("/kr/disuite")
	ArrayResult<DiSuiteTreeNodeModel> csas(@RequestParam Map map);



	/**
	 * 组套列表---查询诊断的关联诊断列表
	 * http://127.0.0.1:8081/kr/disuite/diagnosis/list?xmode=debug&diSuiteCode=123
	 * @param diSuiteCode 组套主键
	 * @return
	 */
	@RequestMapping("/kr/disuite/diagnosis/list")
	ArrayResult<RelDiModelSimple> disListBrowse(@RequestParam Map map);
	
	
	/**
	 * 组套列表---查询 诊断关联的病历列表
	 * diSuiteCode与“ownerType，ownerCode，diCode，enTypeCode”互斥
	 * 当diSuiteCode！=null 时，根据diSuiteCode进行查询
	 * 当diSuiteCode == null 时，且诊断编码为*时，查询通用 对应的模板列表 
	 * 
	 * @param diSuiteCode 组套主键
	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	 * @param diCode 诊断编码
	 * @param enTypeCode 就诊类型
	 * @return
	 * http://127.0.0.1:8081/kr/disuite/mrtemplate/list?xmode=debug&diSuiteCode=123
	 */
	@RequestMapping("/kr/disuite/mrtemplate/list")
	ArrayResult<RelMrTemplateModelSimple> mrTemplateListBrowse(@RequestParam Map map);

	/**
	 * 组套管理，例举所有管理科室
	 * @param enTypeCode 就诊类型
	 * @return
	 * http://127.0.0.1:8081/xap/kr/disuite/admin/deptlist?xmode=debug&enTypeCode=ENM01
	 */
	@RequestMapping("/kr/disuite/admin/deptlist")
	ArrayResult<Dept> csasDeptListForAdmin(@RequestParam Map map);
	
	/**
	 * 组套管理，获取组套列表，自定义分类名称为主（可能没有子节点），诊断为子节点。
	 * 
	 * @param map
	 *            keyset{ownerType,ownerCode,enTypeCode}
	 *            http://127.0.0.1:8081/kr/csas/admin?xmode=debug&enTypeCode=ENM01&ownerType=MDM08.01&ownerCode=00
	 *            http://127.0.0.1:8081/kr/csas/admin?xmode=debug&enTypeCode=ENM01&ownerType=MDM08.02&ownerCode=9300001
	 * @return 数组   diName:'诊断名称',diCode:'诊断编码',ownerType:'所属类型',ownerCode:'所属编码',orgCode:'组织类型',diSuiteTypeCode:'自定义分类编码',diSuiteTypeName:'自定义分类名称',diSuiteCode :'组套编码',id:'索引值',text:'显示值'
	 */
	@RequestMapping("/kr/disuite/admin")
	ArrayResult<DiSuiteTreeNodeModel> csasForAdmin(@RequestParam Map map);
	
	
	/**
	 * 组套列表---验证自定义分类节点名称是否存在，自定义名称在一个 所属编码下 不能重名
	 * http://127.0.0.1:8081/kr/csas/category/exist?xmode=debug&diSuiteTypeName=自定义分类更名成功
	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	 * @param diSuiteTypeName 自定义分类名称
	 * @param enTypeCode 就诊类型
	 * @return  true：可以，false，不可以
	 * http://127.0.0.1:8081/kr/csas/category/can/create?xmode=debug&enTypeCode=ENM01&ownerType=MDM08.01&ownerCode=00&diSuiteTypeName=测试分类节点1
	 * http://127.0.0.1:8081/kr/csas/category/can/create?xmode=debug&enTypeCode=ENM01&ownerType=MDM08.02&ownerCode=9300001&diSuiteTypeName=测试分类节点1
	 */
	@RequestMapping("/kr/disuite/category/can/create")
	SingleResult<Boolean> csasCategoryHasPriToCreate(@RequestParam Map map);
	
	/**
	 * 组套列表---添加自定义分类节点
	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	 * @param diSuiteTypeName 自定义分类名称
	 * @param enTypeCode 就诊类型
	 * http://127.0.0.1:8081/kr/disuite/category/create?xmode=debug&enTypeCode=ENM01&ownerType=MDM08.01&ownerCode=00&diSuiteTypeName=测试分类节点1
	 * http://127.0.0.1:8081/kr/disuite/category/create?xmode=debug&enTypeCode=ENM01&ownerType=MDM08.02&ownerCode=9300001&diSuiteTypeName=测试分类节点1
	 * @param map  map:{ownerType:'所属类型编码',ownerCode:'a1058',diSuiteTypeName:'a',enTypeCode:'ENM01'}
	 * @return  自定义分类model {diSuiteTpCd:'自定义分类编码',diSuiteTpNm:'自定义分类名称',ownerTypeCd:'所属类型编码',ownerCd:'所属编码 ',sortNo:'顺序号' }
	 */
	@RequestMapping("/kr/disuite/category/create")
	SingleResult<DiSuiteTypeModel>  csasCategoryCreate(@RequestParam Map map);
	
	
	/**
	 * 组套列表---删除自定义分类节点
	 * http://127.0.0.1:8081/kr/csas/category/delete?xmode=debug&diSuiteTypeCode=fbc166a2f1c94e15b6e10ea1fb88ab02
	 * @param diSuiteTypeCode: 自定义分类编码 以 “,”分隔的字符串
	 * @return true:成功;false:失败
	 */
	@RequestMapping("/kr/disuite/category/delete")
	SingleResult<Boolean> csasCategoryDelete(@RequestParam Map map);
	
	
	/**
	 * 组套列表---是否可以新增组套
	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	 * @param diSuiteTypeCode 自定义分类编码
	 * @param enTypeCode 就诊类型
	 * @param diCode 诊断编码
	 * @return true:可以,false:不可以
	 * http://127.0.0.1:8081/kr/csas/category/diagnosis/create?xmode=debug&enTypeCode=ENM01&ownerType=MDM08.01&ownerCode=00&diSuiteTypeCode=fbc166a2f1c94e15b6e10ea1fb88ab02&diCode=I20.900
		 * @return
	 */
	@RequestMapping("/kr/disuite/can/create")
	SingleResult<Boolean> DiSuiteCanCreate(@RequestParam Map map);
	
	
	/**
	 * 组套列表---查询 该所属类型 所属编码 的 病历列表，包括

	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	 * @param enTypeCode 就诊类型 
	 * @param diSuiteCode: 组套编码   非必须项目。当新增组套时，此参数为空。当修改组套时，此参数需传递。
	 * @return 数组  mrTemplateCode:'病历模板编码', mrTemplateName:'病历模板编码', ownerType:'所属类型', ownerCode:'所属编码', ownerTypeName:'所属类型名称', ownerName;//所属编码对应的名称', sortNo:'顺序', checked:'是否选中'
	 */
	@RequestMapping("/kr/csa/mrtemplate/list")
	ArrayResult<RelMrTemplateModelSimple> mrTemplateList(@RequestParam Map map);
	

	
	/**
	 * 组套列表---新增/修改组套
	 * 
		 * @return
	 */
	@RequestMapping(value = "kr/disuite/save" , method = RequestMethod.POST )
	SingleResult<Boolean> DiSuiteSave(@ModelAttribute DiSuiteCommitModel model);
	
	/**
	 * 组套列表---为诊断添加关联诊断列表  post方法,测试用接口，非独立接口，属于 新增组套的一个过程接口，
	 * 
	 * @return
	
	@RequestMapping(value = { "/kr/csa/diagnosis/relative/diagnosis/save" }, method = { RequestMethod.POST })
	SingleResult<Boolean> relDisListSave(@ModelAttribute DiSuiteCommitModel model); */
	
	
	/**
	 * 组套列表---为诊断添加关联病历列表， post方法,测试用接口，非独立接口，属于 新增组套的一个过程接口，
	 * 
	 * @return
	 *
	@RequestMapping(value = { "/kr/csa/diagnosis/relative/mrtemplate/save" }, method = { RequestMethod.POST })
	SingleResult<Boolean> relMrTemplateListSave(@ModelAttribute DiSuiteCommitModel model);	  */

	/**
	 * 组套列表---根据组套编码，获取组套详情
	 * @param diSuiteCode:'组套主键'
	 * @return
	 */
	@RequestMapping("/kr/disuite/{diSuiteCode}")
	SingleResult<DiSuiteViewModel> DiSuiteView(@PathVariable("diSuiteCode")  String diSuiteCode);

	/**
	 * 组套列表---在自定义分类节点下删除组套,删除该组套的关联诊断列表和关联病历列表
	 * @param diSuiteCode:'组套主键'
	 * @return
	 */
	@RequestMapping("/kr/disuite/delete")
	SingleResult<Boolean> DiSuiteDelete(@RequestParam Map map);
	

	/*获取服务器时间*/
	@RequestMapping("/kr/csa/sysdate")
	DbDateModel sysdate() ;
	
	/**
	 * 组套列表---查看该科室组套的共享对象列表
	 * @param enTypeCode 就诊类型
	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	* @return
	 */
	@RequestMapping("/kr/disuite/share/view")
	ArrayResult<Dept> DiShareView(@RequestParam Map map);
	
	/**
	 * 组套列表---保存该科室组套的共享对象列表
	 * 
	 * 	private String deptCodeSrc;//共享源code
	private String deptNameSrc;//共享源name
	private Dept[] deptDstArr;//共享目标
	 * @return
	 */
	@RequestMapping(value =  "/kr/disuite/share/save" , method = RequestMethod.POST )
	SingleResult<Boolean> DiShareSave(@ModelAttribute ShareDeptModel model);
	
	/**
	 * 组套列表---删除该组套关联的   病历列表  get方法
	 * @param diSuiteCode:'组套主键'
	 * @return
	*/
	@RequestMapping("/kr/disuite/mrtempate/delete" )
	SingleResult<Boolean> relMrTemplateListDelete(Map map); 

	
	/**
	 * 组套列表---删除该组套关联的   诊断列表  get方法
	 * @param diSuiteCode:'组套主键'
	 * @return
	*/
	@RequestMapping("/kr/disuite/diagnosis/delete" )
	SingleResult<Boolean> relDisListDeleteByDiSuite(@RequestParam Map map); 
	
	
	/**
	 * 组套列表---自定义分类列表
	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	 * @param enTypeCode 就诊类型
	 * @return 自定义分类的数组
	 */
	@RequestMapping("/kr/disuite/category/list")
	ArrayResult<DiSuiteTypeModel>  csasCategoryList(@RequestParam Map map);
	
	
	
	/**
	 * 组套列表---自定义分类列表,保存新增和删除操作，与数据库中的数据进行对比，完成新增和删除
	 * @param ownerType 所属类型编码
	 * @param ownerCode 所属编码
	 * @param enTypeCode 就诊类型
	 * @param categoryNames 自定义类型名称数组
	 * @return 
	 */
	@RequestMapping(value =  "/kr/disuite/category/save" , method = RequestMethod.POST )
	SingleResult<Boolean>  csasCategorySave(@ModelAttribute DiSuiteTypeCommitModel model);
	
	
	
	
	
	
	/**
	 * 组套列表---托拽到本节点前，该顺序号（包括该节点）开始之后的顺序号全部加1
	 * http://127.0.0.1:8081/kr/csas/category/drag/before?xmode=debug&orgCode=00&ownerType=BCM001.02&ownerCode=9300001&moved=0009&target=0008
	 * @param map    map:{orgCode:'00',ownerType:'所属类型编码',ownerCode:'a1058',target:'1005',moved:'1003'} 
	 * @return
	 */
	@RequestMapping("/kr/csas/category/drag/before")
	Map csasCategorySortAddOneBeforeNode(@RequestParam Map map);
	
	/**
	 * 组套列表---托拽到本节点后，该顺序号（不包括该节点）开始之后的顺序号全部加1
	 * http://127.0.0.1:8081/kr/csas/category/drag/after?xmode=debug&orgCode=00&ownerType=BCM001.02&ownerCode=9300001&moved=0009&target=0008
	 * @param map    map:{orgCode:'GLYY',ownerType:'MDM08.02',ownerCode:'9300002',target:'18512321A0E5D001E050007F01007BE3',moved:'18512321A0C0D001E050007F01007BE3'} 
	 * @return
	 */
	@RequestMapping("/kr/csas/category/drag/after")
	Map csasCategorySortAddOneAfterNode(@RequestParam Map map);
	
	
	
	/**
	 * 组套列表---托拽到本节点前，该顺序号（包括该节点）开始之后的顺序号全部加1
	 * http://127.0.0.1:8081/kr/csas/category/diagnosis/drag/before?xmode=debug&orgCode=00&ownerType=BCM001.02&ownerCode=9300001&moved=0009&target=0008
	 * @param map    map:{orgCode:'GLYY',ownerType:'MDM08.02',ownerCode:'9300002',target:'105',moved:'106'} 
	 * @return
	 */
	@RequestMapping("/kr/csas/category/diagnosis/drag/before")
	Map csasDiaSortAddOneBeforeNode(@RequestParam Map map);
	
	/**
	 * 组套列表---托拽到本节点后，该顺序号（不包括该节点）开始之后的顺序号全部加1
	 * http://127.0.0.1:8081/kr/csas/category/diagnosis/drag/after?xmode=debug&orgCode=00&ownerType=BCM001.02&ownerCode=9300001&moved=0005&target=0008
	 * @param map    map:{orgCode:'GLYY',ownerType:'MDM08.02',ownerCode:'9300002',target:'105',moved:'106'} 
	 * @return
	 */
	@RequestMapping("/kr/csas/category/diagnosis/drag/after")
	Map csasDiaSortAddOneAfterNode(@RequestParam Map map);
}
