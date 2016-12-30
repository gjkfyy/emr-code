package fi.clinical.server.cis.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pkuhit.org.Organization;
import pkuhit.org.OrganizationService;
import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserService;
import pkuhit.xap.sy.SysConfigService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;

public class CisLoginVerifyServiceImpl implements CisLoginVerifyService
{
    Logger logger = LoggerFactory.getLogger(CisLoginVerifyServiceImpl.class);
    
    @Reference
    SysConfigService sysConfigService;
    
    @Reference
    UserService userService;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Reference
    OrganizationService organizationService;

    @Override
    public String cisLoginVerify(CisLoginVerifyModel loginModel)
    {
        if (loginModel == null)
        {
            return null;
        }
        // Configuration config = Configuration.getInstance();
        // IEMR系统的URL
        // String iemrUrl = config.getIemrUrl();
        // 登录验证UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 登录组织机构编码
        String organizationCd = "SZLH";
        Map<String, String> map = new HashMap<String, String>();
        map.put("orgTpCd", "ORGM01.02");
        ArrayResult<Organization> orgList = organizationService.search(map);
        if(orgList != null && orgList.getDataList() != null && orgList.getDataList().length>0){
    		organizationCd = orgList.getDataList()[0].getCode();
        }
        // 产生时间
        Date createTime = new Date();
        // DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String createTimeStr = df.format(createTime);
        String createTimeStr = String.valueOf(createTime.getTime());
        String separator = "|";
        
        //获取pass
        
        String pass = "";
        String portal = "";
        String userCd = "";
        
        if (loginModel.getUserCd() != null) {
			SingleResult<User> user = userService.selectById(loginModel.getUserCd());
			userCd = user.getData().getLoginName();
			pass = user.getData().getPassword();
		}
        
        if (loginModel.getPortalCd() != null) {
        	if (loginModel.getPortalCd().equals("1")) {
				portal = "XAPM06.02";
			}else if (loginModel.getPortalCd().equals("2")) {
				portal = "XAPM06.03";
			}else if (loginModel.getPortalCd().equals("3")) {
				portal = "XAPM06.06";
			}else if (loginModel.getPortalCd().equals("4")) {
				portal = "XAPM06.07";
			}else if (loginModel.getPortalCd().equals("7")) {
				portal = "XAPM06.01";
			}else {
//				portal = "XAPM06.02";
			}
		}
        
        String[] paraArray = { userCd, uuid,
        		portal, organizationCd,
                loginModel.getDeptCd(), loginModel.getWardAreaCd(),
                loginModel.getEncounterSn(), loginModel.getDocSn(),
                createTimeStr ,pass,loginModel.getUserCd()};
        String para = StringUtils.join(paraArray, separator);
        logger.info("receive cis param is :"+para);
        // 加密参数
        try
        {
            // byte[] key = Base64.decodeBase64(Configuration.AES_KEY);
            // byte[] data = AESCoder.encrypt(
            // para.getBytes(Configuration.CHARSET), key);
            para = Base64.encodeBase64String(para.getBytes());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        String iemrUrl = (String) sysConfigService.getObject("fi.clinical.server.url");
        iemrUrl += "/ws/bridge?token=" + para;
        return iemrUrl;
    }

    @Override
    public CisLoginVerifyModel parseCisLoginVerifyModel(String para)
    {
        if (para == null)
            return null;
        CisLoginVerifyModel model = new CisLoginVerifyModel();
        String str = new String(Base64.decodeBase64(para));
        String[] params = str.split("\\|");
        // params[0]: 用户Code
        model.setUserCd(params[0]);
        // params[1]: uuid
        // params[2]: 门户ID：1.病历书写2.模板管理3.xx
        model.setPortalCd(params[2]);
        // params[3]: 组织编码
        model.setOrganizationCd(params[3]);
        // params[4]: 科室编码
        model.setDeptCd(params[4]);
        // params[5]: 病区编码
        model.setWardAreaCd(params[5]);
        // params[6]: 病区编码
        model.setEncounterSn(params[6]);
        // params[7]: 病历文书序号
        model.setDocSn(params[7]);
        // params[8]: createTimeStr
        return model;
    }
    
    @Override
    public String parseCisLoginVerifyModelToken(String para)
    {
        if (para == null)
            return null;
        String str = new String(Base64.decodeBase64(para));
        return str;
    }
    
    public static void main(String[] args) {
    	String token = "NDkxMHxkMjJmMDFjYTE2ZjA0YTZkOTVhOGI4NTg1ZjE5YTk1ZXxYQVBNMDYuMDN8U1pMSHw0MzA5fDB8fDF8MTQyODAyNTY2MDYxNHw4MURDOUJEQjUyRDA0REMyMDAzNkRCRDgzMTNFRDA1NXwwMDQ5MTA=";
    	String str = new String(Base64.decodeBase64(token));
    	
    	String paramString = "A1058|3b16685d3dc4411798f7eb138a414a47|5|SZLH|9300001|000114040000|7||1426139421624";
    	String para = Base64.encodeBase64String(paramString.getBytes());
    	
    	System.out.println("token :"+token);
    	System.out.println("base64 decode:"+str);
    	System.out.println("paramString :"+paramString);
    	System.out.println("base64 encode:"+para);
	}
}
