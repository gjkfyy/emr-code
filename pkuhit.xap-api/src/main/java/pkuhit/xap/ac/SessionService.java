package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SessionService
{
    @RequestMapping(value = "/login_info", method = RequestMethod.GET)
    // @RequestMapping(value = "/session", method = RequestMethod.GET)
    Map<String, Object> getCurrentSessionData();

    void setupSessionData(String userId);
}
