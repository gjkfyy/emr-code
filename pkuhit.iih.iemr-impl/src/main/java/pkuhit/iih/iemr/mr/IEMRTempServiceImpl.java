package pkuhit.iih.iemr.mr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.md.MrTypeCustomCategoryItem;
import pkuhit.iih.mr.md.MrTypeCustomCategoryItemService;
import pkuhit.iih.mr.tpl.MrTemplate;
import pkuhit.iih.mr.tpl.MrTemplateService;
import pkuhit.iih.mr.tpl.TemplateNavigatorTreeData;
import pkuhit.iih.mr.tpl.TemplateNavigatorTreeNodeType;
import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.md.DictionaryService;
import pkuhit.md.OwnerType;
import pkuhit.org.Organization;
import pkuhit.org.OrganizationService;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.UserRole;
import pkuhit.xap.ac.UserRoleService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeBuilder;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;

public class IEMRTempServiceImpl implements IEMRTempService {

	@Reference
	MrTemplateService mrTemplateService;//Mr领域的病历模板服务接口
	
	@Reference
	MrTypeCustomCategoryItemService mdMrTpCcatItmService ;//mr领域 病历模板类型与病历模板分类的关系 服务接口
	
	@Reference
	DictionaryService dictionaryService;//字典 服务接口
	
	@Reference
	OrganizationService organizationService;
	
	@Reference
	UserRoleService userRoleService;
	
	public final String ORG_TEMPLATE_ROLE = "XAPM14.11" ; //全院模板管理员
	
	public final String DEPT_TEMPLATE_ROLE = "XAPM14.12" ; //科室模板管理员
	
	public final String ZY_EXCUTE_DOCTOR_ROLE = "XAPM14.02" ; //临床医生
	
	public final String MZ_EXCUTE_DOCTOR_ROLE = "XAPM14.03" ; //门诊医生
	
	//public final String DEPT_TYPE_DEPT = "ENM01.04";
	
	private Logger logger = LoggerFactory.getLogger(IEMRTempServiceImpl.class);

	public MrTypeCustomCategoryItem[] getCategoryListByTypeCode(String typeCode)
	{
		ArrayResult<MrTypeCustomCategoryItem> mdMrTpCcatItmByTemplateType = mdMrTpCcatItmService.getMdMrTpCcatItmByTemplateType(typeCode) ;
		return mdMrTpCcatItmByTemplateType.getDataList();
	}
	
	@Override
	 public  TreeResult<TemplateNavigatorTreeData>  getLazyTree(TemplateNavigatorTreeData io) {

		 //当没有参数时，返回第一层,根据用户业务角色返回所属树
		 Session session = Session.get();
		 //院区编码
		String orgCode = session.getOrgCd() ;
		ArrayResult<TemplateNavigatorTreeData> resultTree = null ;
		ArrayResult<MrTemplate> resultLeaf = null;
		/**
		 * 当输入参数为空时，从session中获取orgCode
		 * 根据节点类型来调用不同的子节点查询接口。
		 * 拼装成树状返回
		 * */
		if(StringUtils.isBlank(orgCode)){
			orgCode = "SZLH";
		}
		StringBuffer ownerCodeBuff = new StringBuffer(orgCode);
		StringBuffer ownerNameBuff = new StringBuffer(this.getOrgName());
		ownerCodeBuff.append(",");
		ownerNameBuff.append(",");
		String userId = session.getUserId() ;
		String userName = session.getUserName() ;
		ownerCodeBuff.append(userId);
		ownerNameBuff.append(userName);
	    Map params = new HashMap();
	    params.put("userId", userId) ;
	    ArrayResult<Organization> deptArrayResult = organizationService.searchUserDepartments(params) ;
	    if(deptArrayResult!= null ){
		    Organization[] deptList = deptArrayResult.getDataList();
			if(deptList != null && deptList.length > 0){
				for(int i = 0 ; i < deptList.length ; i++){
					ownerCodeBuff.append(",");
					ownerCodeBuff.append(deptList[i].getCode());
					ownerNameBuff.append(",");
					ownerNameBuff.append(deptList[i].getName());
				}
			}
	    }
	    TreeBuilder<TemplateNavigatorTreeData> builder  =null;
	   
		TemplateNavigatorTreeData rootNode = new TemplateNavigatorTreeData() ;
		rootNode.setId(getOrgCode());
		rootNode.setText(getOrgName());
		rootNode.setHisOrgCode(getOrgCode());
		rootNode.setHisOrgName(getOrgName());
		if(null == io || null == io.getNodeType()){
			resultTree = mrTemplateService.getCountByOrg(orgCode,ownerCodeBuff.toString(),ownerNameBuff.toString(),io.getKeyWord(),io.getEnTypeCode(),io.getScTemplateCategoryCode(),io.getScTemplateTypeCode(),io.getScStatusCode(),io.getDctNsF());
			builder = TreeBuilder.newTree(getOrgCode(),getOrgName(), rootNode);
		}else if(io.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.ORG)){
			if(null == io.getHisOrgCode() ){
			resultTree = mrTemplateService.getCountByOrg(orgCode,ownerCodeBuff.toString(),ownerNameBuff.toString(),io.getKeyWord(),io.getEnTypeCode(),io.getScTemplateCategoryCode(),io.getScTemplateTypeCode(),io.getScStatusCode(),io.getDctNsF());
			builder = TreeBuilder.newTree(getOrgCode(),getOrgName(), rootNode);
			}else{
				resultTree = mrTemplateService.getCountByOrg(io.getHisOrgCode(),ownerCodeBuff.toString(),ownerNameBuff.toString(),io.getKeyWord(),io.getEnTypeCode(),io.getScTemplateCategoryCode(),io.getScTemplateTypeCode(),io.getScStatusCode(),io.getDctNsF());
				builder = TreeBuilder.newTree(io.getHisOrgCode(),"HisOrgName_"+getOrgName(), rootNode);
			}
		}else if(io.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.OWNER)){
			resultTree = mrTemplateService.getCountOfMrTlCategoryByOwner(io.getHisOrgCode(), io.getOwnerCode(),io.getKeyWord(),io.getEnTypeCode(),io.getScTemplateCategoryCode(),io.getScTemplateTypeCode(),io.getScStatusCode(),io.getDctNsF());
			builder = TreeBuilder.newTree( String.valueOf(System.currentTimeMillis()), rootNode);
		}else if(io.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRCATEGORY)){/*
			resultTree = mrTemplateService.getCountByMrTlCategoryByCategory(io.getHisOrgCode(), io.getOwnerCode(), io.getTemplateCategoryCode(),io.getKeyWord());
			builder = TreeBuilder.newTree( String.valueOf(System.currentTimeMillis()), rootNode);
		}else if(io.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRLEAFCATEGORY)){*/
			resultTree = mrTemplateService.getCountByMrTlCategoryByLeafCategory(io.getHisOrgCode(), io.getOwnerCode(), io.getTemplateCategoryCode(),io.getKeyWord(),io.getEnTypeCode(),io.getScTemplateTypeCode(),io.getScStatusCode(),io.getDctNsF());
			builder = TreeBuilder.newTree( String.valueOf(System.currentTimeMillis()), rootNode);
		}else if(io.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRTYPE)){
			resultLeaf = mrTemplateService.getCountByMrTlCategoryByType(io.getHisOrgCode(), io.getOwnerCode(), io.getTemplateTypeCode(),io.getKeyWord(),io.getEnTypeCode());
			builder = TreeBuilder.newTree( String.valueOf(System.currentTimeMillis()), rootNode);
		}			
		if(null!=resultTree && null == resultLeaf ){
			//当 枝节点（非模板名称）

	        if (resultTree.getDataList() != null)
	        {
	            for (TemplateNavigatorTreeData node : resultTree.getDataList())
	            {
	            	if(node.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.OWNER)){
	            		if(OwnerType.DEPARTMENT.equalsIgnoreCase( node.getOwnerTypeCode())){
	            			SingleResult<Organization> selectByCode = organizationService.selectByCode(node.getOwnerCode());
	            			if(null != selectByCode && null != selectByCode.getData() ){
	            				String preText =  node.getText() ;
	            				int i =  preText.indexOf("（"); 
	            				String countStr = "";
	            				if( i > -1 ){
	            					countStr = preText.substring(i) ;
	            				}
	            				node.setText(((Organization )(selectByCode.getData())).getName() + countStr );
	            			}
	            		}
	            	}
	            	node.setLeaf(Boolean.FALSE);
	            	node.setChecked(Boolean.FALSE);
	            	logger.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):"+node.getId());
	            	logger.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):"+node.getText());

	            	builder.addChildByData( String.valueOf(System.currentTimeMillis()), node.getText(), node);
	            }
	        }
	        TreeNode<TemplateNavigatorTreeData> tree = builder.build();
	        TreeResult<TemplateNavigatorTreeData> r = new TreeResult<TemplateNavigatorTreeData>();
	        r.setRoot(tree);
	        return r;
		}else{
			//当叶节点（模板名称）
			//builder = TreeBuilder.newTree("root", new TemplateNavigatorTreeData());
	        if (resultLeaf.getDataList() != null)
	        {
	            for (MrTemplate tpl : resultLeaf.getDataList())
	            {
	            	TemplateNavigatorTreeData node = new TemplateNavigatorTreeData();
	            	node.setTemplateCode(tpl.getCode());
	            	node.setTemplateName(tpl.getName());
	            	node.setId( String.valueOf(System.currentTimeMillis()));
	            	String text = tpl.getName()+"（"+tpl.getStatusName()+"）" ;
	            	node.setText(text);
	            	node.setFilePk(tpl.getFilePk());
	            	node.setLeaf(Boolean.TRUE);
	            	node.setHisOrgCode(io.getHisOrgCode());
	            	node.setOwnerTypeCode(io.getOwnerTypeCode());
	            	node.setOwnerCode(io.getOwnerCode());
	            	node.setTemplateTypeCode(io.getTemplateTypeCode());
	                builder.addChildByData(tpl.getCode(), text, node,Boolean.TRUE);
	            }
	        }
	        TreeNode<TemplateNavigatorTreeData> tree = builder.build();
	        TreeResult<TemplateNavigatorTreeData> r = new TreeResult<TemplateNavigatorTreeData>();
	        r.setRoot(tree);
	        return r;
		}
	 }

	private boolean verifyExistKey(Map map, String key) {
		if (map.containsKey(key) && null != map.get(key)
				&& ! ("null".equalsIgnoreCase((String) map.get(key)) || "".equalsIgnoreCase((String) map.get(key))) ) {
			return true;
		}
		return false;
	}
	

	
	@Override
	//全部树  目前在mr 领域内实现
	public TreeResult<TemplateNavigatorTreeData> getTree(Map<String, String> condition) {
		String sessionOrgName = getOrgName();
		if(!verifyExistKey(condition,"enTypeCode")){
			//空树			
			TemplateNavigatorTreeData rootNode = new TemplateNavigatorTreeData() ;
			rootNode.setHisOrgCode(getOrgCode());
			rootNode.setHisOrgName(getOrgName());
			rootNode.setId("rootCode");
			rootNode.setText(sessionOrgName);
			TreeBuilder<TemplateNavigatorTreeData> builder = TreeBuilder.newTree("/",sessionOrgName,rootNode);
			TreeNode<TemplateNavigatorTreeData> tree = builder.build();
			TreeResult<TemplateNavigatorTreeData> r = new TreeResult<TemplateNavigatorTreeData>();
			r.setRoot(tree);
			return r ;
		}
		//将orgname 放入查询参数中
		condition.put("SessionOrgName", sessionOrgName);
		Session session = Session.get() ;
		String userId = session.getUserId();

		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		//params.put("orgCode", orgCode);

    	String enTypeCode = condition.get("enTypeCode") ;
    	/**
    	 * 根据操作人的角色列举他的科室
    	 * 如果是全院模板管理员角色，能浏览全院、所有科室、他本人的模板，可以管理全院、所有科室、他本人的模板
    	 * 如果是临床医生，能浏览全院、出诊科室、他本人的模板，可以管理全院、角色配置的科室、他本人的模板
    	 * */
		Map DeptCodeMap = mrTemplateService.getPriDeptList(enTypeCode).getData();
		condition.put("deptCodeArr", (String)DeptCodeMap.get("deptCodeArr"));
		condition.put("deptNameArr",  (String)DeptCodeMap.get("deptNameArr"));
		TreeResult<TemplateNavigatorTreeData>  r = mrTemplateService.getTree(condition) ;
		return r ;
	
		
	} 
	
	private String getOrgCode() {
		Session session = Session.get();
		String orgCd = session.getOrgCd();
		if (StringUtils.isBlank(orgCd)) {
			orgCd = "SZLH";
		}
		return orgCd;
	}
	
	private String getOrgName() {
		Session session = Session.get();
		String orgCd = session.getOrgCd();
		// TODO... 会话里怎么没有名称？
		String undefinedOrgNm = "模板树根节点";
		String orgNm = "" ;
		SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
				Organization.OBJ_CD, orgCd);
		if(null == simpleItems || simpleItems.length == 0 || null == simpleItems[0]){
			
		}else{
			orgNm = simpleItems[0].getText();
			if (StringUtils.isBlank(orgNm)) {
				orgNm = undefinedOrgNm;
			}
		}
		return orgNm;
	}
}
