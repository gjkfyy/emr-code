package pkuhit.xap.ac.support;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import pkuhit.xap.ac.LoginError;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.SessionService;
import xap.sv.app.Application.Mode;
import xap.sv.component.ModeAware;
import xap.sv.session.DefaultWebSessionManager;
import xap.sv.session.SessionScope;
import xap.sv.shiro.AuthenticationSupport;
import xap.sv.util.ThreadContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationSupportImpl implements AuthenticationSupport,
        ModeAware, InitializingBean
{
    SessionService sessionService;

    ObjectMapper objectMapper = new ObjectMapper();

    Mode mode;

    final static String DUMMY_USER_ID = "1001";

    public void prepareSuccessResponse(ServletResponse response)
            throws Exception
    {
        String userId = (String) SessionScope.getPrincipal();
        if (Mode.DEVELOPMENT.equals(mode))
        {
            // TODO 配置
            userId = DUMMY_USER_ID;
        }
        sessionService.setupSessionData(userId);
        if (response != null)
        {
            Session session = Session.get();

            HttpServletResponse hsr = (HttpServletResponse) response;
            hsr.setHeader(DefaultWebSessionManager.DEFAULT_SESSION_ID_NAME,
                    session.getToken());

            // LoginInfo info = accessControlService.getLoginInfo();
            // TODO 不使用BeanMap
            // BeanMap bm = BeanMap.create(info);
            this.objectMapper.writeValue(response.getOutputStream(),
                    session.asMap());
            response.flushBuffer();
        }
    }

    public void prepareFailureResponse(AuthenticationException e,
            ServletResponse response) throws Exception
    {
        xap.sv.util.ThreadContext.put(AuthenticationSupport.LOGIN_ERROR_KEY, e);
        LoginError error = getLastLoginError();
        this.objectMapper.writeValue(response.getOutputStream(), error);
        response.flushBuffer();
    }

    LoginError getLastLoginError()
    {
        AuthenticationException e = ThreadContext.get(
                AuthenticationSupport.LOGIN_ERROR_KEY,
                AuthenticationException.class);
        LoginError error = new LoginError();
        // TODO 国际化
        if (e instanceof org.apache.shiro.authc.UnknownAccountException)
        {
            error.setDesc("用户名不存在或该用户已停用");
        }
        else if (e instanceof org.apache.shiro.authc.IncorrectCredentialsException)
        {
            error.setDesc("密码错误");
        }else {
			error.setDesc("登录失败，若密码设置为空，则密码输入1234");
		}
        // TODO 实现
        return error;
    }

    @Override
    public void setMode(Mode mode)
    {
        this.mode = mode;
    }

    public void setSessionService(SessionService sessionService)
    {
        this.sessionService = sessionService;
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        Assert.notNull(sessionService, "sessionService must not null");
    }

}
