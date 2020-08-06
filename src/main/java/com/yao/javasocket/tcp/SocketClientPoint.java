package com.yao.javasocket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * socket客户端
 * @author: <a href="tivenninesongs@163.com">yaoxuguang</a>
 * @createDate: Created in 2020/7/23 14:54
 */
public class SocketClientPoint {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8081);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //发送数据
            for (int i = 0; i < 10; i++) {
                String sendString = "我是客户端" + i;
                System.out.println("send data :" + sendString);
                sendData(outputStream,sendString);
            }
            inputStream.close();
//            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           /* if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }

    private static void sendData(OutputStream outputStream,String sendString){
        try {
            outputStream.write(sendString.getBytes());
//            outputStream.flush();
//            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
