package com.yao.javasocket.inetaddress;

import java.net.*;
import java.util.Enumeration;

/**
 * 网络地址
 * @author: <a href="tivenninesongs@163.com">yaoxuguang</a>
 * @createDate: Created in 2020/8/4 15:51
 */
public class InetAddressExample {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Interface "+networkInterface.getName()+":");
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()){
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("\tAddress"+ (inetAddress instanceof Inet4Address ? "(v4)":
                            (inetAddress instanceof Inet6Address ? "(v4)":"(?)")));
                    System.out.println(": "+inetAddress.getHostAddress());
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        for (String arg : args) {
            try {
                System.out.println(arg + ":");
                InetAddress[] allByName = InetAddress.getAllByName(arg);
                for (InetAddress inetAddress : allByName) {
                    System.out.println("\t"+inetAddress.getHostName()+"/"+inetAddress.getHostAddress());
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}
