package top.wsure.utils;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

public class ConnectorUtil {
    private void bindPort(String host, int port) throws Exception {
        Socket s = new Socket();
        s.bind(new InetSocketAddress(host, port));
        s.close();
    }
    public boolean isPortAvailable(int port) {
        Socket s = new Socket();
        try {
            bindPort("0.0.0.0", port);
            bindPort(InetAddress.getLocalHost().getHostAddress(), port);
            return true;
        } catch (Exception e) {
            CQ.logInfo("Port can't use!",""+port);
            return false;
        }
    }
    public int findAvailablePort(int start, int end){
        int s=start<end?start:end;
        int e=start>end?start:end;

        for (int i=s;i<e;i++)
        {
            if(isPortAvailable(i))
                return i;
        }
        return -1;
    }

}
