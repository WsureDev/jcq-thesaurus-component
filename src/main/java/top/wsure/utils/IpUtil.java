package top.wsure.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IpUtil {
    public static String INTRANET_IP = getIntranetIp();
    public static String INTERNET_IP = getInternetIp();

    private IpUtil(){}
    /**
     * 获取内网IP
     * @return
     * @throws Exception
     */
    private static String getIntranetIp(){
        try{
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e){
            throw new RuntimeException("can't find IP");
        }
    }

    public static String getInternetIp(){
        try{
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            Enumeration<InetAddress> address;
            while (networks.hasMoreElements()){
                address = networks.nextElement().getInetAddresses();
                while (address.hasMoreElements()){
                    ip = address.nextElement();
                    if(ip != null
                            && ip instanceof InetAddress
                            && ip.isSiteLocalAddress()
                            && !ip.getHostAddress().equals("")){
                        return ip.getHostAddress();
                    }
                }
            }
            return INTRANET_IP;
        } catch (SocketException e) {
            throw new RuntimeException("");
        }
    }
}
