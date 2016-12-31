package pkuhit.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import pkuhit.org.dao.auto.WardDeptDao;
import pkuhit.org.dao.auto.OrgDao;
import pkuhit.org.dao.auto.entity.EiNisWardConfig;
import pkuhit.org.dao.auto.entity.Org;
import pkuhit.org.dao.auto.entity.WardDept;
import pkuhit.org.dao.custom.CustomNisWardConfigDao;
import pkuhit.org.dao.custom.CustomOrgDao;
import pkuhit.org.dao.custom.CustomWardDeptDao;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.UserRoleService;
import pkuhit.xap.dao.auto.XapUserDao;
import pkuhit.xap.dao.auto.entity.XapUser;
import pkuhit.xap.dao.custom.CustomXapUserDao;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.pub.MessageCode;
import pkuhit.xap.sy.SysConfigService;
import xap.sv.annotation.Reference;
import xap.sv.i18n.MessageSource;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeBuilder;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.servlet.RequestScope;
import xap.sv.util.BeanCopyUtil;

public class OrganizationServiceImpl implements OrganizationService
{
	private Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    @Autowired
    OrgDao orgDao;
    
    @Autowired
    XapUserDao xapUserDao;
    
    @Autowired
    CustomXapUserDao customXapUserDao;
    
    @Reference
    ParamsSetService paramsSetService;
    
    @Autowired
    CustomNisWardConfigDao customNisWardConfigDao;
    
    @Autowired
    CustomOrgDao customOrgDao;

    @Autowired
    CustomWardDeptDao customWardDeptDao;
    
    @Autowired
    WardDeptDao WardDeptDao;
    
    @Reference
    MessageSource messageSource;
    
    @Autowired
    SysConfigService sysConfigService;
    
    @Autowired
    UserRoleService userRoleService;

    @Override
    public SingleResult<Organization> create(Organization organization)
    {
        // TODO Auto-generated method stub
        Org org = new Org();

        if (StringUtils.isEmpty(organization.getCode()))
        {
            throw new NotificationException(new Notification(
                    MessageCode.M10010,
                    messageSource.fetchMessage(MessageCode.M10021)));
        }

        BeanCopyUtil.ModelToEntity(org, organization);
        orgDao.insert(org);
        SingleResult<Organization> singleResult = new SingleResult<Organization>();
        singleResult.setData(organization);
        return singleResult;
    }

    @Override
    public SingleResult<Organization> update(Organization organization)
    {
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(organization.getCode()))
        {
            throw new NotificationException(new Notification(
                    MessageCode.M10010, "id"));
        }
        Org org = new Org();
        BeanCopyUtil.beanCopy(org, organization);
        orgDao.updateExcludeNull(org);
        SingleResult<Organization> singleResult = new SingleResult<Organization>();
        return singleResult;
    }

    @Override
    public String delete(String organizationId)
    {
        // TODO Auto-generated method stub
        Org org = orgDao.selectById(organizationId);
        orgDao.delete(org);
        return "";
    }

    @Override
    public SingleResult<Organization> selectByCode(String organizationCd)
    {
        // TODO Auto-generated method stub
        Org org = orgDao.selectById(organizationCd);
        Organization organization = new Organization();
        BeanCopyUtil.beanCopy(organization, org);
        SingleResult<Organization> singleResult = new SingleResult<Organization>();
        singleResult.setData(organization);
        return singleResult;
    }

    /**
     * 
     * @description 根据parOrgCd和orgTpCd查询组织列表
     * @author jiao_xiantong
     * @date 2014年12月5日 下午1:11:16
     * @param params
     * @return
     * @see pkuhit.org.OrganizationService#search(java.util.Map)
     */
    @Override
    public ArrayResult<Organization> search(Map<String, String> params)
    {
        // TODO Auto-generated method stub
        List<Org> list = customOrgDao.selectOrgList(params.get("orgTpCd"));
        ArrayResult<Organization> arrayResult = new ArrayResult<Organization>();
        if (list != null)
        {
            Organization[] organizationList = new Organization[list.size()];
            int i = 0;
            for (Org org : list)
            {
                Organization organization = new Organization();
                BeanCopyUtil.beanCopy(organization, org);
                organizationList[i] = organization;
                i++;
            }
            arrayResult.setDataList(organizationList);
        }
        return arrayResult;
    }
    
    /**
     * 
     * @description 根据parOrgCd和orgTpCd查询组织列表
     * @author jiao_xiantong
     * @date 2014年12月5日 下午1:11:16
     * @param params
     * @return
     * @see pkuhit.org.OrganizationService#search(java.util.Map)
     */
    @Override
    public ArrayResult<Organization> searchByKeyword(Map<String, String> params)
    {
    	// TODO Auto-generated method stub
    	String keyword = params.get("keyword");
    	String deptTpCd = params.get("deptTpCd");
    	String id = params.get("id");
    	int pageSize = 100;
    	if(StringUtils.hasText(params.get("pageSize"))){
    		pageSize = Integer.parseInt(params.get("pageSize"));
    	}
    	if (keyword != null) {
			keyword = keyword.toLowerCase();
		}
		SelectOptions options = SelectOptions.get().offset(0).limit(pageSize).count();
    	List<WardDept> list = customOrgDao.selectDeptList(keyword,id,deptTpCd,options);
    	ArrayResult<Organization> arrayResult = new ArrayResult<Organization>();
    	if (list != null)
    	{
    		Organization[] organizationList = new Organization[list.size()];
    		int i = 0;
    		for (WardDept wardDept : list)
    		{
    			Organization organization = new Organization();
    			pkuhit.xap.util.BeanCopyUtil.entityToModel(organization, wardDept, null, null);
    			organizationList[i] = organization;
    			i++;
    		}
    		arrayResult.setDataList(organizationList);
    	}
    	return arrayResult;
    }

    @Override
    public ArrayResult<Organization> searchAllWardDept(String deptCode,String deptTypeCode)
    {
        // TODO Auto-generated method stub
        List<Org> list = customWardDeptDao.selectAll(deptCode,deptTypeCode);
        ArrayResult<Organization> arrayResult = new ArrayResult<Organization>();
        if (list != null)
        {
            Organization[] organizationList = new Organization[list.size()];
            int i = 0;
            for (Org org : list)
            {
                Organization organization = new Organization();
                BeanCopyUtil.beanCopy(organization, org);
                organizationList[i] = organization;
                i++;
            }
            arrayResult.setDataList(organizationList);
        }
        return arrayResult;
    } 
    
    @Override
    public TreeResult<Organization> searchTree(Map<String, String> params)
    {
        // TODO Auto-generated method stub
        List<Org> list = customOrgDao.selectOrgList(params.get("orgTpCd"));
        TreeBuilder<Organization> builder = TreeBuilder.newTree("root",
                new Organization());
        if (list != null)
        {
            for (Org org : list)
            {
                Organization organization = new Organization();
                BeanCopyUtil.beanCopy(organization, org);
                List<Org> children = customOrgDao.selectOrgList(null);
                boolean flag = true;
                if (children != null && children.size() > 0)
                {
                    flag = false;
                }
                builder.addChildByData(organization.getCode(),
                        organization.getName(), organization, flag);
            }
        }
        TreeNode<Organization> tree = builder.build();
        TreeResult<Organization> r = new TreeResult<Organization>();
        r.setRoot(tree);
        return r;
    }
    
	@Override
	public ArrayResult<Organization> searchUserDepartments(Map<String, String> params) {
	    ArrayResult<Organization> results = new ArrayResult<Organization>();
	    ArrayResultBuilder<Organization> builder = ArrayResultBuilder.newArrayResult(Organization.class);
		
		String deployMode = "1";
		String userId = params.get("userId");
		deployMode = (String) sysConfigService.getObject("deployMode");
		List<Org> orgList = this.customOrgDao.selectUserDeptList(userId,deployMode);
		if (orgList != null && orgList.size() > 0) {
			Organization[] voArray = new Organization[orgList.size()];
			for (int i = 0; i < orgList.size(); i++) {
				Org org = orgList.get(i);
				Organization organization = new Organization();
				BeanCopyUtil.beanCopy(organization, org);
				voArray[i] = organization;
			}
			builder.withData(voArray);
			results = builder.build();
	        results.setTotal(orgList.size());
		}else{
			builder.withData(new Organization[0]);
			results = builder.build();
		}
		return results;
	}

	@Override
	public ArrayResult<OrganizationForCombox> searcDepartmentsByEntypecode(
			Map<String, String> params) {
		String enTypeCode = null ;
		String deptTypeCode =  null ;
		String deptCode = null ;
		if(params.containsKey("deptTpCd")){
			deptTypeCode =  (String)params.get("deptTpCd");
	/*		enTypeCode = (String)params.get("enTypeCode");
			deptTypeCode = ParameterUtils.enType2DeptType(enTypeCode) ;*/
		}
		ArrayResultBuilder<OrganizationForCombox> builder = ArrayResultBuilder.newArrayResult(OrganizationForCombox.class);
		Session session = Session.get() ;
		//得到权限部门列表
		List<String> userRoleMrbDeptList = userRoleService.userRoleMrbDeptList(session.getUserId(), null);
		if(null == userRoleMrbDeptList){//没有可以查看的科室，则返回空
			log.debug("权限部门列表userRoleMrbDeptList is null,   没有可以查看的科室，则返回空数组" );
			ArrayResult<OrganizationForCombox> rs = builder.build();
			rs.setTotal(0);
			return rs ;
		}else{
			if(userRoleMrbDeptList.isEmpty()){
				log.debug("权限部门列表userRoleMrbDeptList is empty,可以查看全部科室" );
			}else{
				log.debug("权限部门列表userRoleMrbDeptList  size:" + userRoleMrbDeptList.size()  );
				for(String code :userRoleMrbDeptList){
					log.debug("权限部门代码为："+code);
				}
			}
		}
		List<Map<String, Object>> list = customWardDeptDao.selectDept(deptCode,deptTypeCode);
		if(list!= null && list.size() > 0){
			int size = userRoleMrbDeptList.isEmpty()?list.size():userRoleMrbDeptList.size() ;
			log.debug("部门下拉框size:"+ size );
			//OrganizationForCombox[] voArray = new OrganizationForCombox[size ];
			List<OrganizationForCombox> voList = new ArrayList<OrganizationForCombox>();
			int i = 0 ;
			for(Map<String, Object> map : list ){
				OrganizationForCombox vo = new OrganizationForCombox();
				String iteratorDeptCode = (String)map.get("CODE") ;
				log.debug("循环变量iteratorDeptCode:" + iteratorDeptCode  );
				if(!userRoleMrbDeptList.isEmpty() && !userRoleMrbDeptList.contains(iteratorDeptCode)){
					//权限部门列表不空，且不包含该该部门代码，则continue
					log.debug("权限部门列表不空，且不包含该该部门代码，则continue");
					continue;
				}
				//权限部门列表为空，或者权限部门列表包含该部门代码，则返回到前台
				vo.setCode((String)map.get("CODE"));
				vo.setName((String)map.get("NAME"));
				log.debug("第"+i+"项目："+((String)map.get("CODE")+"_"+(String)map.get("NAME")));
				voList.add(vo);
/*				voArray[i] = vo ;
				i++ ;*/
			}
			if(!voList.isEmpty()){
				OrganizationForCombox[] voArray =    new OrganizationForCombox[voList.size() ];
				int j = 0 ;
				for(OrganizationForCombox vo: voList ){
					voArray[j] = vo ;
					j++;
				}
				builder.withData(voArray);
			}else{
				log.debug("voArray is empty");
			}
		}
		ArrayResult<OrganizationForCombox> rs = builder.build();
		return rs ;
	}
	
	@Override
	public String selectDeptType(String deptCd){
	    WardDept wardDept = WardDeptDao.selectById(deptCd);
	    return wardDept.getDeptTpCd();
	}
}
