package szlh.iih.test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.tuscany.sca.core.ExtensionPointRegistry;

import xap.sv.app.Application;
import xap.sv.bundle.XapBundle;
import xap.sv.bundle.XapBundleContext;
import xap.sv.bundle.XapBundleContextExtensionPoint;

public abstract class AutoConfig
{
    // private static ConfigRuntime runtime;

    public static void main(String[] args) throws Exception
    {
        String[] cfs = collectConfigFiles();
        StringBuilder sb = new StringBuilder();
        for (String cf : cfs)
        {
            sb.append("\"" + cf + "\" ");
        }
        File curDir = new File(System.getProperty("user.dir"));
        File tmp = new File(curDir, "autoconfig");
        Writer writer = new FileWriter(tmp);
        writer.write("autoconfig.exe -i on " + sb);
        writer.flush();
        writer.close();
    }

    static String[] collectConfigFiles() throws Exception
    {
        List<String> files = new ArrayList<String>();
        ExtensionPointRegistry registry = Application.getInstance().getExtensionPoints();
        XapBundleContextExtensionPoint xbcep = registry.getExtensionPoint(XapBundleContextExtensionPoint.class);
        XapBundleContext xapBundleContext = xbcep.getXapBundleContext();
        for (XapBundle xb : xapBundleContext.getAllBundles())
        {
            files.add(new File(xb.getLocation().getRoot().toURI()).getAbsolutePath());
        }
        return files.toArray(new String[0]);
    }

}