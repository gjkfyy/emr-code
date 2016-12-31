package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.util.StringUtils;

import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.md.DictionaryService;
import pkuhit.org.OrgEmpService;
import xap.sv.annotation.Reference;
import xap.sv.app.Application;
import xap.sv.app.Application.Mode;
import xap.sv.model.SingleResult;
import xap.sv.scope.ScopeManager;
import xap.sv.session.SessionScope;
import xap.sv.util.ConversionUtils;

public class DefaultSessionService implements SessionService
{
    @Reference
    ScopeManager scopeManager;

    @Reference
    DictionaryService dictionaryService;
    
    @Reference
    OrgEmpService orgEmpService;

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> getCurrentSessionData()
    {
        Session session = Session.get();
        return ConversionUtils.convert(session, Map.class);
    }

    @Override
    public void setupSessionData(String userId)
    {
        String userName = null;
        if (Mode.PRODUCTION.equals(Application.getInstance().getMode()))
        {
             // TODO
//             DataObject o = dos.getObject("XAPM12", userId);
            SimpleItem [] item = dictionaryService.getSimpleItems("XAPM12", userId);
             if (userId != null && item != null && item.length > 0 && item[0] != null)
             {
//             User user = o.getObject(User.class);
            	 userId = item[0].getText();
                 SimpleItem [] empItem = dictionaryService.getSimpleItems("ORGB04", userId);
                 if(empItem!=null &&  empItem.length>0 && empItem[0]!=null){
                	 userName = empItem[0].getText();
                 }
                 System.out.println("-----------userName is :" + userName);
                SingleResult<String> rs = orgEmpService.selectByCode(userId);
                if(rs != null ){
                	
                	String orgEmpName = rs.getData();
                	if (StringUtils.hasText(orgEmpName)){
                	 }
                	if(StringUtils.hasText(userName) && StringUtils.hasText(orgEmpName) && !orgEmpName.equalsIgnoreCase(userName)){
                		dictionaryService.updateDictionary("ORGB04");
                		dictionaryService.updateDictionary("XAPM12");
                		userName = orgEmpName ;
                	}else {
					}
                }
             }
             
        }
        if (!StringUtils.hasText(userName))
        {
            userName = userId;
        }
        SessionScope scope = scopeManager.getScope(SessionScope.class);
        scope.put(Session.SESSION_USER_ID_KEY, userId);
        scope.put(Session.SESSION_USER_NAME_KEY, userName);
    }
}
