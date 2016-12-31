package pkuhit.iih.iemr.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import ei.cis.service.CisMzClinicRoomConfigService;
import ei.cis.service.CisService;

import pkuhit.iih.iemr.pub.CaUtil;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.MedicalRecord;
import pkuhit.iih.mr.wr.MedicalRecordService;
import pkuhit.iih.mr.wr.MrTreeData;
import pkuhit.org.NisWardConfigService;
import pkuhit.org.Organization;
import pkuhit.org.OrganizationService;
import pkuhit.xap.ac.MenuTreeData;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.User;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.po.Portal;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;
import xap.sv.notification.NotificationManager;
import xap.sv.servlet.RequestScope;

public class PortalServiceImpl implements PortalService
{ 
    public static Logger log = LoggerFactory.getLogger(PortalServiceImpl.class);
    // 我的患者
    public static final String MINE_PATIENT = "minePatient";
    
    // 科室患者
    public static final String DEPT_PATIENT = "deptPatient";
    
    // 病历文书
    public static final String MR_DOC = "XAPM07.05";
    
    // 病历模板
    public static final String MR_TEMPALTE = "XAPM07.27";
    
    // 菜单分类:功能
    public static final String MENU_FUNCTION = "function";
    
    // 菜单分类:病历自定义分类
    public static final String MENU_MR_CUSTCATEGORY = "mrCustcategory";
    
    // 菜单分类:病历文书
    public static final String MENU_MR_DOC = "mrDoc";
    
    // 门诊科室类型编码
    public static final String OUTPATIENT_DEPT_TYPE = "ORGM02.05";
    
    @Reference
    pkuhit.xap.ac.UserService UserService;
    
    @Reference
    pkuhit.xap.ac.UserPortalService userPortalService;

    @Reference
    pkuhit.xap.ac.UserRoleService userRoleService;

    @Reference
    pkuhit.xap.ac.UserMenuService userMenuService;

    @Reference
    pkuhit.md.DictionaryService dictionaryService;

    @Reference
    NotificationManager notificationManager;
    
    @Reference
    OrganizationService organizationService;
    
//    @Reference
//    EncounterService encounterService;
    
    @Reference
    MedicalRecordService medicalRecordService;
    
    @Reference
    pkuhit.iih.mr.wr.AmrService amrService;
    
    @Reference
    ParamsSetService paramsSetService;
    
    @Reference
    CisMzClinicRoomConfigService cisMzClinicRoomConfigService;
    
    @Reference
    CisService cisService;
    
    @Reference
    NisWardConfigService nisWardConfigService;

    @Override
    public String selectLoginUser()
    {
        Session session = Session.get();
        if(session == null)
            return null;
        return session.getUserId();
    }
    
    @Override
    public Organization[] selectHospitalArea(Map<String, String> params)
    {
        ArrayResult<Organization> results = organizationService.search(params);
        if(results != null){
            Organization[] organizations = results.getDataList();
            return organizations;
            
        }
        return null;
    }

    @Override
    public ArrayResult<Organization> selectDepartment(Map<String, String> params)
    {
        ArrayResult<Organization> results = new ArrayResult<Organization>();
        ArrayResultBuilder<Organization> builder = ArrayResultBuilder.newArrayResult(Organization.class);
        String ip= RequestScope.getNativeRequest().getServletRequest().getRemoteAddr();
        
        //判断登录用户身份：0护士、1医生
        Short dctNsF = null;
        String userId = params.get("userId");
        Map<String, String> searchMap = new HashMap<String,String>();
        searchMap.put("userId", userId);
        searchMap.put("statusCd", "XAPM01.01");
        ArrayResult<User> users = UserService.search(searchMap);
        if(users != null && users.getTotal() > 0){
            User user = users.getDataList()[0];
            dctNsF = user.getDctNsF();
        }
        System.out.println("用户身份：" + dctNsF);
        
        if (dctNsF == 1){
            //医生登录
            String paramValue = paramsSetService.searchFunFlagByKey("DOCTOR_DEPT_ROOM_BY_IPADDR").getData();
            System.out.println("DOCTOR_DEPT_ROOM_BY_IPADDR参数：" + paramValue);
            if("1".equals(paramValue)){
                //用户权限与出诊科室无关，出诊科室由机器IP决定
                List<Map<String, Object>> list = cisMzClinicRoomConfigService.searchDeptByIp(ip);
                if(list != null && list.size() > 0){
                    System.out.println("科室数量：" + list.size());
                    Organization[] voArray = new Organization[list.size()];
                    for(int i=0; i<list.size(); i++){
                        Map<String, Object> map = list.get(i);
                        Organization organization = new Organization();
                        System.out.println("科室编码：" + map.get("dept_sn"));
                        System.out.println("科室名称：" + map.get("name"));
                        organization.setCode(map.get("dept_sn")==null?"":map.get("dept_sn").toString());
                        organization.setName(map.get("name")==null?"":map.get("name").toString());
                        voArray[i]=organization;
                    }
                    builder.withData(voArray);
                    results = builder.build();
                    results.setTotal(list.size());
                }
            }else if("2".equals(paramValue)){
                //住院出诊科室来自表org_emp_edpt
                results = organizationService.searchUserDepartments(params);
                int size = results.getDataList().length;
                //门诊出诊科室由客户端IP决定
                List<Map<String, Object>> list = cisMzClinicRoomConfigService.searchDeptByIp(ip);
                if(list != null && list.size() > 0){
                    Organization[] voArray = new Organization[list.size()+size];
                    System.arraycopy(results.getDataList(), 0, voArray, 0, size);
                    for(int i=0; i<list.size(); i++){
                        Map<String, Object> map = list.get(i);
                        Organization organization = new Organization();
                        System.out.println("科室编码：" + map.get("dept_sn"));
                        System.out.println("科室名称：" + map.get("name"));
                        organization.setCode(map.get("dept_sn")==null?"":map.get("dept_sn").toString());
                        organization.setName(map.get("name")==null?"":map.get("name").toString());
                        voArray[i+size]=organization;
                    }
                    builder.withData(voArray);
                    results = builder.build();
                    results.setTotal(list.size());
                }
            }else{
                //用户权限与出诊科室相关
                results = organizationService.searchUserDepartments(params);
            }
        }else{
            //护士登录
            String paramValue = paramsSetService.searchFunFlagByKey("CHECH_IP_SEARCH_SELECT").getData();
            System.out.println("CHECH_IP_SEARCH_SELECT参数：" + paramValue);
            if("1".equals(paramValue)){
                //用户权限与病区无关，病区由机器IP决定
                List<Map<String, Object>> list = nisWardConfigService.searchOrgByIp(ip);
                if(list != null && list.size() > 0){
                    System.out.println("科室数量：" + list.size());
                    Organization[] voArray = new Organization[list.size()];
                    for(int i=0; i<list.size(); i++){
                        Map<String, Object> map = list.get(i);
                        System.out.println("科室编码：" + map.get("WARD_SN"));
                        System.out.println("科室名称：" + map.get("WARD_NM"));
                        Organization organization = new Organization();
                        organization.setCode(map.get("WARD_SN")==null?"":map.get("WARD_SN").toString());
                        organization.setName(map.get("WARD_NM")==null?"":map.get("WARD_NM").toString());
                        voArray[i]=organization;
                    }
                    builder.withData(voArray);
                    results = builder.build();
                    results.setTotal(list.size());
                }
            }else{
                //用户权限与病区相关
                results = organizationService.searchUserDepartments(params);
            }
        }
        return results;
    }
    
    @Override
    public Portal[] selectPortal(Map<String, String> params)
    {
        String userId = params.get("userId");
        String orgCd = params.get("orgCd");
        String deptType = organizationService.selectDeptType(orgCd);
        String param = paramsSetService.searchFunFlagByKey("DOCTOR_DEPT_ROOM_BY_IPADDR").getData();
        if("1".equals(param) || ("2".equals(param) && OUTPATIENT_DEPT_TYPE.equals(deptType))){//用户权限与出诊科室无关，出诊科室由机器IP决定
            orgCd = null;
        }
        ArrayResult<Portal> results = userPortalService.getUserPortalList(userId, orgCd);
        return results.getDataList();
    }

    @Override
    public TreeResult<MenuTreeData> searchPortalMenus(Map<String, String> params)
    {
        String deptType = organizationService.selectDeptType((String)params.get("orgCd"));
        String param = paramsSetService.searchFunFlagByKey("DOCTOR_DEPT_ROOM_BY_IPADDR").getData();
        if("1".equals(param) || ("2".equals(param) && OUTPATIENT_DEPT_TYPE.equals(deptType))){//用户权限与出诊科室无关，出诊科室由机器IP决定
            params.put("orgCd", null);
        }
        TreeResult<MenuTreeData> results = userMenuService.getUserMenuTree(params);
        return results;
    }
    
    @Override
    public TreeResult<MenuTreeData> selectPortalMenus(Map<String, String> params)
    {
        TreeResult<MenuTreeData> results = userMenuService.getUserMenuTree(params);
        TreeNode<MenuTreeData> tree = results.getRoot();
        tree = this.addTreeNode(tree,params);
        return results;
    }
    
    @SuppressWarnings("static-access")
    private TreeNode<MenuTreeData> addTreeNode(TreeNode<MenuTreeData> tree,Map<String, String> condition){
        List<TreeNode<MenuTreeData>> menuLst = tree.getChildren();
        for(TreeNode<MenuTreeData> node : menuLst){
            MenuTreeData data = node.getData();
            if(data.getNodeType() == null)
                data.setNodeType(this.MENU_FUNCTION);
            String code = data.getCode();
            if(MR_DOC.equals(code)){
                TreeResult<MrTreeData> mrTree = medicalRecordService.tree(condition);
                TreeNode<MrTreeData> mrNode = mrTree.getRoot();
                TreeNode<MenuTreeData> menuNode = this.mrNodeToMenuNode(mrNode);
                List<TreeNode<MenuTreeData>> children = menuNode.getChildren();
                node.setChildren(children);
                if(children != null && children.size() > 0)
                    node.setLeaf(false);
            }
            if(MR_TEMPALTE.equals(code)){
                
            }
            this.addTreeNode(node,condition);
        }
        return tree;
    }
    
    @SuppressWarnings("static-access")
    private TreeNode<MenuTreeData> mrNodeToMenuNode(TreeNode<MrTreeData> mrNode){
        TreeNode<MenuTreeData> newNode = new TreeNode<MenuTreeData>();
        MenuTreeData menuData = new MenuTreeData();
        BeanUtils.copyProperties(mrNode.getData(),menuData);
        if("1".equals(menuData.getNodeType()))
            menuData.setNodeType(this.MENU_MR_CUSTCATEGORY);
        else
            menuData.setNodeType(this.MENU_MR_DOC);
        newNode.setData(menuData);
        newNode.setId(mrNode.getId());
        newNode.setText(mrNode.getText());
        newNode.setLeaf(mrNode.isLeaf());
        List<TreeNode<MrTreeData>> children = mrNode.getChildren();
        for(TreeNode<MrTreeData> node:children){
            TreeNode<MenuTreeData> child = this.mrNodeToMenuNode(node);
            newNode.addChild(child);
        }
        return newNode;
    }
    
//    @SuppressWarnings("static-access")
//    @Override
//    public EncounterModel[] selectPatients(Map<String, String> params)
//    {
//        String userId = params.get("userId") == null ? null
//                : (String) params.get("userId");
//        String orgCd = params.get("orgCd") == null ? null
//                : (String) params.get("orgCd");
//        String enTpCd = params.get("enTpCd") == null ? null
//                : (String) params.get("enTpCd");
//        Map<String, String> m = new HashMap<String, String>();
//        m.put("enTpCd", enTpCd);
//        if(params.get("group") != null){
//            String group = (String)params.get("group");
//            if(this.MINE_PATIENT.equals(group)){
//                m.put("curMngDctId", userId);
//            }
//            if(this.DEPT_PATIENT.equals(group)){
//                m.put("curDeptCd", orgCd);
//            }
//        }
//        if(params.get("search") != null){
//            String search = (String)params.get("search");
//            //m.put("paNm", search);
//            m.put("curBedCd", search);
//        }
////        ArrayResult<EncounterModel> results = encounterService.getEncounterListByCondition(m);
//        return results.getDataList();
//    }
//    
//    @Override
//    public EncounterModel[] selectEncounters(Map<String, String> params){
//        String enPk = params.get("enPk") == null ? null
//                : (String) params.get("enPk");
//        SingleResult<EncounterModel> result = encounterService.getEncounterDetail(enPk);
//        EncounterModel en = result.getData();
//        if(en != null){
//            String paId = en.getPaId();
//            Map<String, String> m = new HashMap<String, String>();
//            m.put("paId", paId);
//            ArrayResult<EncounterModel> results = encounterService.getEncounterListByCondition(m);
//            return results.getDataList();
//        }
//        return null;
//    }
    
    @Override
    public void saveDepartment(Map<String, String> params)
    {
        String deptId = params.get("deptId") == null ? null
                : (String) params.get("deptId");
        String orgCd = params.get("orgCd") == null ? null
                : (String) params.get("orgCd");
        Session session = Session.get();
        session.setDeptId(deptId);
        session.setOrgCd(orgCd);
    }

    @Override
    public void test()
    {
        notificationManager.fatal("12345");
        notificationManager.commit();
    }
    
    @Override
    public SingleResult<Amr> setDoctor(String id, Amr io)
        throws Throwable {

        SingleResult<Amr> result = amrService.get(id);
        if(result != null){
            Amr value = result.getData();
            value.setCurDrcDctId(io.getCurDrcDctId());
            value.setCurMojDctId(io.getCurMojDctId());
            return amrService.update(id, value);
        }
        return null;
    }
    
    @Override
    public SingleResult<Map> validateUser(Map<String, String> condition){
        String userId = (String)condition.get("userId");
        String orgCd = (String)condition.get("orgCd");
        String portalCd = (String)condition.get("portalCd");
        String menuCd = (String)condition.get("menuCd");
        boolean result = false;
        ArrayResult<Portal> portals = userPortalService.getUserPortalList(userId, orgCd);
        if(portals != null){
            Portal[] portalLst = portals.getDataList();
            if(portalLst.length > 0){
                for(int i=0;i<portalLst.length;i++){
                    Portal portal = portalLst[i];
                    if(portalCd.equals(portal.getCode())){
                        result = true;
                        break;
                    } 
                }
            }
        }
        if(result){
            TreeResult<MenuTreeData> menus = userMenuService.getUserMenuTree(condition);
            if(menus != null){
                List<TreeNode<MenuTreeData>> menuLst = menus.getRoot().getChildren();
                result = this.validateUserForMenu(menuLst, menuCd);
            }
        }
        SingleResult<Map> rs = new SingleResult<Map>();
        Map mapResult = new HashMap();
        if(result){
            mapResult.put("validate", "true");
        }else{
            mapResult.put("validate", "false");
        }
        rs.setData(mapResult);
        return rs;
    }
    
    @Override
    public SingleResult<User> getCACertUser(Map<String, String> condition){
        String caSubject = (String)condition.get("caSubject");
        String uniqueId = (String)condition.get("uniqueId");
        SingleResult<User> rs = new SingleResult<User>();
        Map<String, Object> mapResult = new HashMap<String, Object>();
        List<Map<String, Object>> lst = cisService.searchUserByCert(caSubject, uniqueId);
        if(lst != null && lst.size() > 0){
            mapResult = lst.get(0);
            String userId = mapResult.get("USER_ID")==null?"":(String)mapResult.get("USER_ID");
            rs = UserService.selectUserById(userId);
            return rs;
        }
        User user = new User();
        rs.setData(user);
        return rs;
    }
    
    private boolean validateUserForMenu(List<TreeNode<MenuTreeData>> menus,String menuCd){
        if(menus != null && menus.size() > 0){
            for(TreeNode<MenuTreeData> node: menus){
                if(menuCd.equals(node.getData().getCode())){
                    return true;
                }else{
                    List<TreeNode<MenuTreeData>> children = node.getChildren();
                    if(this.validateUserForMenu(children, menuCd))
                        return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public int searchMrCountByPatient(String enc_id){
        Map<String, String> param = new HashMap<String,String>();
        param.put("encounterPk", enc_id);
        int mrCnt = 0;
        try
        {
            ArrayResult<MedicalRecord> result = medicalRecordService.search(param);
            mrCnt = result.getTotal();
        }
        catch (Throwable e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mrCnt;
    }
    
    @Override 
    public Map<String,String> getBJCASigndata() throws Throwable{
        String cert = "", random = "", signData = "", dn = "";
        Map<String,String> result = new HashMap<String,String>();
        try{
            if (CaUtil.public_sed == null)
                CaUtil.getSedInstance();
            if (CaUtil.public_sed != null) {
                cert = CaUtil.public_sed.getServerCertificate();
                random = CaUtil.public_sed.genRandom(24);
                signData = CaUtil.public_sed.signData(random);
                dn = CaUtil.public_sed.getCertInfo(cert, 21);
                result.put("cert", cert);
                result.put("random", random);
                result.put("signData", signData);
                result.put("dn", dn);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    @Override 
    public Map<String,String> getBJCACertInfo(Map<String, String> param) throws Throwable{
        String certInfo = "";
        String strCert = (String)param.get("strCert");
        String strOid = (String)param.get("strOid");
        Map<String,String> result = new HashMap<String,String>();
        try{
            if (CaUtil.public_sed == null)
                CaUtil.getSedInstance();
            if (CaUtil.public_sed != null) {
                certInfo = CaUtil.public_sed.getCertInfoByOid(strCert, strOid);
                result.put("certInfo", certInfo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
