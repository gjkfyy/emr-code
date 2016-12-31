package pkuhit.iih.iemr.mr;

import java.util.HashMap;
import java.util.Map;

import pkuhit.iih.mr.tpl.GETreeData;
import pkuhit.iih.mr.tpl.MrGroupElementService;
import pkuhit.org.Organization;
import pkuhit.org.OrganizationService;
import pkuhit.xap.ac.Session;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.TreeResult;

public class GroupElementServiceImpl implements GroupElementService {
	@Reference
	MrGroupElementService mrGroupElementService;
	
	@Reference
	OrganizationService organizationService;
	
	@Override
	public TreeResult<GETreeData> tree(Map<String, String> condition) {
		
		/*Modiefy by wujunhui 2015/01/04 重构了获取用户所属部门列表的方法  */
		/*String orgCode = Session.get().getOrgCd() ;
		Map<String, String> params = new HashMap<String, String>();
		if(null != orgCode){
	           params.put("parOrgCd", orgCode);
		}
		params.put("orgTpCd",OrgType.DEPT);
		ArrayResult<Organization> results = organizationService.search(params);
		//根据parOrgCd和orgTpCd查询结构列表
		if(results != null){
            Organization[] orgs = results.getDataList();
            
            if(orgs != null && orgs.length > 0){
            	StringBuffer sbOrgCodes = new StringBuffer();
            	StringBuffer sbOrgNames = new StringBuffer();
                for(int i=0;i<orgs.length;i++){
                	if(i > 0){
                		sbOrgCodes.append(",");
                		sbOrgNames.append(",");
                	}
                    Organization org = orgs[i];
                    sbOrgCodes.append(org.getCode());
                    sbOrgNames.append(org.getName());
                }
                System.out.println(sbOrgCodes.toString());
                System.out.println(sbOrgNames.toString());
            	condition.put("deptCodeArr", sbOrgCodes.toString());
            	condition.put("deptNameArr", sbOrgNames.toString());
            }
		}*/
		
		String userId = Session.get().getUserId();
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		
		ArrayResult<Organization> results = organizationService.searchUserDepartments(params);
		if (results != null && results.hasData()) {
			Organization[] orgs = results.getDataList();
			StringBuffer sbOrgCodes = new StringBuffer();
        	StringBuffer sbOrgNames = new StringBuffer();
        	
        	for(int i=0;i<orgs.length;i++){
                Organization org = orgs[i];
                sbOrgCodes.append(org.getCode());
                sbOrgNames.append(org.getName());
                
                if (i != orgs.length -1) {
                	sbOrgCodes.append(",");
            		sbOrgNames.append(",");
                }
            }
        	
        	condition.put("deptCodeArr", sbOrgCodes.toString());
        	condition.put("deptNameArr", sbOrgNames.toString());
		}
		//End
		
		TreeResult<GETreeData> treeResult = mrGroupElementService.tree(condition);
		return treeResult;
	}

}
