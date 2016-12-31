package pkuhit.iih.mr.tpl;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.md.MrType;
import pkuhit.iih.mr.md.MrTypeCustomCategory;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface MrTemplateService {
	
	/**
	 *  【医疗记录模板】是否有权限可以创建
	 * @param ownerTypeCode //所属类型编码
	 * @param ownerCode //所属编码
	 * @return true false
	 */
	@RequestMapping(value = "/mr/tpl/template/userRoleCanCreate", method = RequestMethod.GET)
	SingleResult<Boolean> HasPri(@RequestParam("ownerTypeCode") String ownerTypeCode,@RequestParam("ownDeptCd") String ownDeptCd);
	
	/**
	 *  【医疗记录模板】名称是否存在。
	 *  需求： 同一所属编码下不能重名。 住院：1.全院通用下，不允许重名 2.同一科室下，不允许重名 3.同一个人下，不允许重名
	 *  @param code  把此code排除在外
	 * @param name //病历模板名称
	 * @param ownDeptCd 所属编码
	 * @return true已经存在   false不存在
	 * http://localhost:8081/xap/mr/tpl/template/HasDuplicationOfName?_dc=1428373912022&name=0403-4&ownDeptCd=SZLH
	 */
	@RequestMapping(value = "/mr/tpl/template/HasDuplicationOfName", method = RequestMethod.GET)
	SingleResult<Boolean> HasDuplicationOfName(@RequestParam("code") String code,@RequestParam("name") String name,@RequestParam("ownDeptCd") String ownDeptCd);
	
	/**
	 * 获取所有 病历模板类型 叶节点
	 * */
	@RequestMapping(value = "/mr/tpl/template/leaftypecode", method = RequestMethod.GET)
	ArrayResult<MrType> searchLeafTypeCode();	
	/**
	 *  【医疗记录模板】新建服务（单记录）
	 * @param MrTemplate value
	 * @return 单条医疗记录模板
	 */
	@RequestMapping(value = "/mr/tpl/template", method = RequestMethod.POST)
	SingleResult<MrTemplate> create(@ModelAttribute TemplateInputModel value);

	
	/**
	 *  【医疗记录模板】更新服务（单记录）
	 * @param MrTemplate value
	 * @return 单条医疗记录模板
	 */
	@RequestMapping(value = "/mr/tpl/template/{id}", method = RequestMethod.PUT)
	SingleResult<MrTemplate> update(@PathVariable("id") String id ,@ModelAttribute TemplateInputModel value);
	
	/**
     *  【医疗记录模板】更新服务（单记录）
     * @param MrTemplate value
     * @return 单条医疗记录模板
     */
    @RequestMapping(value = "/mr/tpl/template/reset/{id}", method = RequestMethod.PUT)
    SingleResult<MrTemplate> updateReset(@PathVariable("id") String id ,@ModelAttribute TemplateInputModel value);
	
	/**
	 *  【医疗记录模板】查询服务（单记录）
	 * @param String id
	 * @return 单条医疗记录模板
	 */
	@RequestMapping(value = "/mr/tpl/template/{id}", method = RequestMethod.GET)
	SingleResult<MrTemplate> searchById(@PathVariable("id")  String id);
	
	/**
	 *  【医疗记录模板】查询服务（多记录）
	 * @param excludeDelete 当输入0或false时，包含删除。否则，不包含删除
	 * @param statusCode 单个或多个状态码，以 | 分隔
	* @param name//名称 模糊查询
	* @param rootCode//根记录编码
	* @param orgCode //组织机构编码
	* @param ownerTypeCode //所属类型编码
	* @param ownerCode //所属编码
	* @param typeCode// 单个或者多个医疗记录模板类型编码  ，以 | 分隔
	* @param mrCategoryCode 单个或者多个医疗记录模板类型编码  ，以 | 分隔
	* @param baseTemplateCode //基础模板编码
	* @param enTypeCode 就诊类型
	* @param pageNum 当前页数    从1开始。默认值为1，
	* @param pageSize 每页记录数   默认值25
	* @return 
	 */
	@RequestMapping(value = "/mr/tpl/template", method = RequestMethod.GET)
	ArrayResult<MrTemplate> search(@RequestParam Map condition);	
	
	/**
	 *  【医疗记录模板】前台查询服务查询服务（多记录）
	* @param orgCode //组织机构编码
	* @param name//名称 模糊查询
	* @param ownerTypeCode //所属类型编码
	* @param ownerCode //所属编码
	* @param typeCode// 单个或者多个医疗记录模板类型编码  ，以 | 分隔
	* @param mrCategoryCode 单个或者多个医疗记录模板类型编码  ，以 | 分隔
	* @param tplUseCodeList 模板适用编码
	* @param enTypeCode 就诊类型
	* @param pageNum 当前页数    从1开始。默认值为1，
	* @param pageSize 每页记录数   默认值25
	* @return 
	 */
	@RequestMapping(value = "/mr/tpl/template/canuse", method = RequestMethod.GET)
	ArrayResult<MrTemplate> searchTemplateToUse(@RequestParam Map condition);	

	/**
     *  【医疗记录模板】前台查询服务查询服务（多记录）
    * @param name//名称 模糊查询
    * @param hospitalArea //医院编码
    * @param departCode //科室编码
    * @param userCode //用户编码
    * @param mrCategoryCode 医疗记录模板类型分组编码
    * @param typeCode// 医疗记录模板类型编码
    * @return 
     */
    @RequestMapping(value = "/mr/tpl/template/create", method = RequestMethod.GET)
    ArrayResult<MrTemplate> searchTemplateToCreate(@RequestParam Map condition);
    
	//根据门诊类型，获得病历模板的浏览科室列表
	@RequestMapping(value = "/mr/tpl/getPriDeptList", method = RequestMethod.GET)
	SingleResult<Map> getPriDeptList(@RequestParam("enTypeCode") String enTypeCode  ) ;
	/**
	 * 【医疗记录模板】删除服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	@RequestMapping(value = "/mr/tpl/template", method = RequestMethod.DELETE)
	SingleResult<BatchOperationResult>  delete(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【组合元素】提交服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	@RequestMapping(value = "/mr/tpl/submitted/template", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> submit(@ModelAttribute ArrayInputModel ids) ;
	
	
	/**
	 * 【组合元素】审核通过服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	@RequestMapping(value = "/mr/tpl/verified/template", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> verify(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【组合元素】驳回已提交服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	@RequestMapping(value = "/mr/tpl/rejected/template", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> reject(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【医疗记录模板】发布服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	@RequestMapping(value = "/mr/tpl/published/template", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> publish(@ModelAttribute ArrayInputModel ids) ;

	/**
	 * 【医疗记录模板】停用服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	@RequestMapping(value = "/mr/tpl/stopped/template", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> stop(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【医疗记录模板】启用服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	@RequestMapping(value = "/mr/tpl/activated/template", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> activate(@ModelAttribute ArrayInputModel ids) ;
	
	/**
     * 【医疗记录模板】启用服务（多记录）
     * @param ids 多个记录主键
     * @return 批量更新结果医疗记录模板
     */
    @RequestMapping(value = "/mr/tpl/default/template", method = RequestMethod.POST)
    SingleResult<BatchOperationResult> defaultSet(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 
	 * 标记删除。因为各节点查询 子节点 未完成
	 * 
	 * 
	 * 【医疗记录模板】导航树
	 * * @param  orgCode 院区编码
	 * @return 导航树
	 */
//	@RequestMapping(value = "/mr/tpl/tree/template", method = RequestMethod.GET)
	@Deprecated
	TreeResult<TemplateNavigatorTreeData> tree(@RequestParam Map<String, String> condition) ;
	
	
	/**
	 * 【医疗记录模板】导航树---所属院区的每个所属类型 所属编码对应的模板个数
	 * * @param  orgCode 院区编码
	 * @return map<编码  个数>
	 */
	@RequestMapping(value = "/mr/tpl/tree/count/owner", method = RequestMethod.GET)
	ArrayResult<TemplateNavigatorTreeData> getCountByOrg(@RequestParam("orgCode") String orgCode,@RequestParam("ownerCodeJoin") String ownerCodeJoin,@RequestParam("owerNameJoin") String owerNameJoin ,@RequestParam("keyWord") String keyWord,@RequestParam("enTypeCode") String enTypeCode
			,@RequestParam("scTemplateCategoryCode") String scTemplateCategoryCode,@RequestParam("scTemplateTypeCode") String scTemplateTypeCode,@RequestParam("statusCode") String statusCode,@RequestParam("dctNsF") String dctNsF) ;
	
	/**
	 * 【医疗记录模板】导航树---所属院区的每个病历模板自定义分类（ 首层）  对应的模板个数
	 * * @param  ownerCode 所属编码
	 * @return map<编码  个数>
	 */
	@RequestMapping(value = "/mr/tpl/tree/count/first/category", method = RequestMethod.GET)
	ArrayResult<TemplateNavigatorTreeData>  getCountOfMrTlCategoryByOwner(@RequestParam("orgCode") String orgCode,@RequestParam("ownerCode") String ownerCode  ,@RequestParam("keyWord") String keyWord,@RequestParam("enTypeCode") String enTypeCode
			,@RequestParam("scTemplateCategoryCode") String scTemplateCategoryCode,@RequestParam("scTemplateTypeCode") String scTemplateTypeCode,@RequestParam("statusCode") String statusCode,@RequestParam("dctNsF") String dctNsF) ;
	
	/**
	 * 【医疗记录模板】导航树---所属院区的每个病历模板自定义分类（非首层 非叶） 对应的模板个数
	 * * @param  mrCategoryCode 自定义分类编码
	 * @return map<编码  个数>
	 */
	@RequestMapping(value = "/mr/tpl/tree/count/category", method = RequestMethod.GET)
	ArrayResult<TemplateNavigatorTreeData> getCountByMrTlCategoryByCategory(@RequestParam("orgCode") String orgCode,@RequestParam("ownerCode") String ownerCode,@RequestParam("mrCategoryCode") String mrCategoryCode ,@RequestParam("keyWord") String keyWord,@RequestParam("enTypeCode") String enTypeCode,@RequestParam("dctNsF") String dctNsF);
	
	
	/**
	 * 【医疗记录模板】导航树---所属院区的每个病历模板自定义分类（叶） 对应的模板个数
	 * * @param  mrCategoryCode 自定义分类编码
	 * @return map<编码  个数>
	 */
	@RequestMapping(value = "/mr/tpl/tree/count/leafcategory", method = RequestMethod.GET)
	ArrayResult<TemplateNavigatorTreeData>  getCountByMrTlCategoryByLeafCategory(@RequestParam("orgCode") String orgCode,@RequestParam("ownerCode") String ownerCode,@RequestParam("mrCategoryCode") String mrCategoryCode ,@RequestParam("keyWord") String keyWord,@RequestParam("enTypeCode") String enTypeCode
			,@RequestParam("scTemplateTypeCode") String scTemplateTypeCode,@RequestParam("statusCode") String statusCode,@RequestParam("dctNsF") String dctNsF) ;
	
	/**
	 * 【医疗记录模板】导航树---所属院区的每个病历模板类型   对应的模板个数
	 * * @param  TypeCode 类型编码
	 * @return map<编码  个数>
	 */
	@RequestMapping(value = "/mr/tpl/tree/count/type", method = RequestMethod.GET)
	ArrayResult<MrTemplate>  getCountByMrTlCategoryByType(@RequestParam("orgCode") String orgCode,@RequestParam("ownerCode") String ownerCode,@RequestParam("typeCode") String typeCode ,@RequestParam("keyWord") String keyWord,@RequestParam("enTypeCode") String enTypeCode
			) ;

	 /**
	  * 目前和iemr的 方法实现一致。只是为了测试执行时间
	  * 
	  * 全部加载树，
	  * 包括按“keyWord 名称”查询，查询范围包括【科室名称，自定义分类名称，类型名称，病历模板名称】，查询结果以树形显示,鼠标定位在第一个叶节点
	  * 按“mrTemplateCode 病历模板的编码”查询结果以树形显示。定位在第一个叶节点
	  * keyWord 名称搜索关键词
	  * mrTemplateCode 病历模板编码
	  * deptCode 业务科室编码(如果有多个通过','进行分割)
	  * loadMode 加载模式。1：全量加载，2：延迟加载。默认为1
	  * */
//	 @RequestMapping(value = "/mr/tpl/tree/notlazy", method = RequestMethod.GET) 	 
	 TreeResult<TemplateNavigatorTreeData>  getTree(@RequestParam Map<String, String> condition)  ; 
	 
	 
	 /**
	  * 全部加载树，
	  * @param enTypeCode 就诊类型
	  * @param dctNsF 医护使用标记：1-医生；0-护士
	  * @param onlyThisDept  是否只有本科室创建的模板，1-是 ，0-本科室之外还有别的科室分享给本科室的模板所属科室.默认是1
	  * */
	 @RequestMapping(value = "/mr/tpl/tree/use/notlazy", method = RequestMethod.GET) 	 
	 TreeResult<TemplateNavigatorTreeData>  getUseTree(@RequestParam Map<String, String> condition)  ; 
	 /*
	  * 树
	  * */
		/**
		 * 查询病历文书类型列表。需要按照树形结构在名称中进行缩进。
		 * @param condition.keyword 搜索关键字
		 * @return
		 */
		@RequestMapping(value = "/mr/type/tree", method = RequestMethod.GET)
		ArrayResult<MrType> searchMrTypeCode(@RequestParam Map<String, String> condition);
		
		/**
		 * 查询病历自定义分类列表。需要按照树形结构在名称中进行缩进。
		 * @param condition.keyword 搜索关键字
		 * @return
		 */
		@RequestMapping(value = "/mr/ccat/tree", method = RequestMethod.GET)
		ArrayResult<MrTypeCustomCategory> searchMrCCatCode(@RequestParam Map<String, String> condition);
		
		/**
		 * 所属类型下拉选择框
		 * @param condition.keyword 搜索关键字
		 * @return
		 
		@RequestMapping(value = "/mr/tpl/groupElementCategorys", method = RequestMethod.GET)
		ArrayResult<GroupElementCategory> searchOwerCode(@RequestParam Map<String, String> condition);

		/**
		 * 模板适用类型下拉选择
		 * @param condition.keyword 搜索关键字
		 * @return
		 
		@RequestMapping(value = "/mr/tpl/groupElementCategorys", method = RequestMethod.GET)
		ArrayResult<GroupElementCategory> searchCategory(@RequestParam Map<String, String> condition);
	 */
		
		/**
         * 查询基础模板filePk。
         * @param code 
         * @return
         */
        @RequestMapping(value = "/mr/tpl/smbtfp", method = RequestMethod.GET)
        SingleResult<Map> searchMrBTemplateFile(@RequestParam("code") String code);
        
        /**
         * 查询基础模板filePk。
         * @param code 
         * @return
         */
        @RequestMapping(value = "/mr/tpl/smbtcr", method = RequestMethod.GET)
        SingleResult<Map> searchMrBTemplateFileByFilePk(@RequestParam("filePk") String filePk);
        
        /**
    	 * 【医疗记录模板】停用服务（多记录）
    	 * @param ids 多个记录主键
    	 * @return 批量更新结果医疗记录模板
    	 */
    	@RequestMapping(value = "/mr/tpl/template/changeSort", method = RequestMethod.GET)
    	SingleResult<Map> changeSort(@RequestParam("selCode") String selCode,@RequestParam("tagCode") String tagCode,@RequestParam("model") String model) ;
    	
    	/**
    	 * 【解析xml】解析xml（多记录）
    	 * @return SingleResult<Map<String,Object>>
    	 * @throws Throwable
    	 */
    	@RequestMapping(value = "/mr/tpl/tree/formxml", method = RequestMethod.PUT)
    	SingleResult<Map<String,Object>> searchTree(@ModelAttribute MrFormXml mrFormXml)
    		throws Throwable;
    	
    	/**
    	 * 【生成xml】生成xml服务（多记录）
    	 * @return SingleResult<MedicalRecord>
    	 * @throws Throwable
    	 */
    	@RequestMapping(value = "/mr/tpl/tree/createxml", method = RequestMethod.PUT)
    	SingleResult<Map<String,Object>> createXml(@ModelAttribute MrFormXml mrFormXml)//(@RequestParam Map<String, Object> condition)
    		throws Throwable;
    	
    	/**
         * 加载病历模板树.
         * mrTplCCat 自定义分类
         * mrTplTypeCd 病历类型
         * mrTplStatCd 模板状态
         * keyWord 名称搜索关键词
         * enTypeCode 就诊类型
         * dctNsF 医护标识
         * @return TreeResult<TemplateNavigatorTreeData>
         * */
        @RequestMapping(value = "/mr/tpl/newtree", method = RequestMethod.GET)     
        TreeResult<TemplateNavigatorTreeData> getTreeForTpl(@RequestParam Map<String, String> condition);
        
        /**
         * 【医疗记录模板】查询服务（多记录）
         * @param statusCode 状态码
         * @param dctNsF//医护标记
         * @param name//名称 模糊查询
         * @param ownerTypeCode //所属类型编码
         * @param ownerCode //所属编码
         * @param typeCode// 医疗记录模板类型编码
         * @param mrCategoryCode 医疗记录模板自定义分类编码
         * @param enTypeCode 就诊类型
         * @param pageNum 当前页数    从1开始。默认值为1，
         * @param pageSize 每页记录数   默认值25
         * @return 
         */
        @RequestMapping(value = "/mr/tpl/search", method = RequestMethod.GET)
        ArrayResult<MrTemplate> searchMrTemplates(@RequestParam Map<String, String> condition);
}
