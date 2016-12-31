package xap.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class Start
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            startJetty();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void startJetty() throws Exception
    {
        int timeout = 3600000;

        Server server = new Server();
        SocketConnector connector = new SocketConnector();

        // Set some timeout options to make debugging easier.
        connector.setMaxIdleTime(timeout);
        connector.setSoLingerTime(-1);
        connector.setPort(8081);
        server.addConnector(connector);

        WebAppContext bb = new WebAppContext();
        bb.setServer(server);
        bb.setContextPath("/xap");
        bb.setWar("src/main/webapp");

        server.setHandler(bb);

        System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
        server.start();
        System.in.read();
        System.out.println(">>> STOPPING EMBEDDED JETTY SERVER");
        server.stop();
        server.join();
    }
}
