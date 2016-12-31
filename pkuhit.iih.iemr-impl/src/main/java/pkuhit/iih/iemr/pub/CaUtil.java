package pkuhit.iih.iemr.pub;

import cn.org.bjca.client.exceptions.ApplicationNotFoundException;
import cn.org.bjca.client.exceptions.InitException;
import cn.org.bjca.client.exceptions.ParameterTooLongException;
import cn.org.bjca.client.exceptions.SVSConnectException;
import cn.org.bjca.client.security.SecurityEngineDeal;

public class CaUtil
{
    public static SecurityEngineDeal public_sed;
    
    public static SecurityEngineDeal getSedInstance() {
        if (public_sed != null)
            return public_sed;
        try{
            String webappName = "SVSDefault";
            public_sed = SecurityEngineDeal.getInstance(webappName);
        } catch(SVSConnectException e) {
            e.printStackTrace();
        } catch(ApplicationNotFoundException e) {
            e.printStackTrace();
        } catch(InitException e) {
            e.printStackTrace();
        }
        return public_sed;
    }
    
    public static String getTimeStamp(String inData) {
        String tsRep = "";
        SecurityEngineDeal ts_sed = null;
        try {
            ts_sed = SecurityEngineDeal.getInstance("TSSDefault");
            String tsReq = ts_sed.createTimeStampRequest(inData);
            tsRep = ts_sed.createTimeStamp(tsReq);
        } catch (SVSConnectException e) {
            e.printStackTrace();
        } catch (ApplicationNotFoundException e) {
            e.printStackTrace();
        } catch (InitException e) {
            e.printStackTrace();
        } catch (ParameterTooLongException e) {
            e.printStackTrace();
        }
        return tsRep;
    }
}
