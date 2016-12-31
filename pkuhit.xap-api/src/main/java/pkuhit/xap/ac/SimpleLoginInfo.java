package pkuhit.xap.ac;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class SimpleLoginInfo implements LoginInfo
{
    final static String USER_NAME_SESSION_KEY = SimpleLoginInfo.class.getName()
        + "_user_name_session_key";

    final static String ATTIBUTES_SESSION_KEY = SimpleLoginInfo.class.getName()
        + "_attributes_session_key";

    @Override
    public String getUserId()
    {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        return (String) principal;
    }

    @Override
    public String getUserName()
    {
        return (String) SecurityUtils.getSubject().getSession().getAttribute(
                USER_NAME_SESSION_KEY);
    }

    @Override
    public synchronized void setAttribute(String key, Object attr)
    {
        Map<String, Object> attributes = this.getAttributes();
        attributes.put(key, attr);
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(ATTIBUTES_SESSION_KEY, attributes);
    }

    @Override
    public synchronized <T> T getAttribute(String key, Class<T> valueType)
    {
        Map<String, Object> attributes = this.getAttributes();
        Object obj = attributes.get(key);
        if (valueType.isInstance(obj))
            return valueType.cast(obj);
        return null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    Map<String, Object> getAttributes()
    {
        Session session = SecurityUtils.getSubject().getSession();
        Object obj = session.getAttribute(ATTIBUTES_SESSION_KEY);
        if (obj == null)
        {
            obj = new HashMap<String, Object>();
        }
        return (Map) obj;
    }
}
