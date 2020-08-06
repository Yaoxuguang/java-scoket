package com.yao.javasocket.tcp;

import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端
 * @author: <a href="tivenninesongs@163.com">yaoxuguang</a>
 * @createDate: Created in 2020/7/23 14:54
 */
public class SocketServerPoint {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8081);
            Socket accept = serverSocket.accept();
            OutputStream outputStream = accept.getOutputStream();
            InputStream inputStream = accept.getInputStream();

            //接收数据
            String receiveStr;
            while (true){
                receiveStr = receiveData(inputStream);
                if(StringUtils.isEmpty(receiveStr)){
                    break;
                }
                System.out.println(receiveStr+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           /* if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }

    private static String receiveData(InputStream inputStream){
        String data = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            data = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
