package pkuhit.xap.sy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SysConfigServiceImpl implements SysConfigService{

	@Override
	public Object getObject(String id) {
		// TODO Auto-generated method stub
		return properties.get(id);
	}
	
	
	private static Properties properties;

    static
    {
        init("settings.properties");
    }

    static void init(final String fileName)
    {
        properties = new Properties();
        InputStream in = null;
        String message = null;
        try
        {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(
                    fileName);
            properties.load(in);
        }
        catch (FileNotFoundException e)
        {

            message = "Setting文件不存在";
        }
        catch (IOException e)
        {
            message = "操作Setting文件时发生错误";
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    message = "关闭Setting文件时发生错误";
                }
                if (message != null)
                {
                    //DebugLogger.log(message);
                }
            }
        }

//        getWorkspace();
//        getBaseServerUrl();
//        getLauncherUrl();
//        getStaticResourceServerUrl();
    }
	 
   
}
