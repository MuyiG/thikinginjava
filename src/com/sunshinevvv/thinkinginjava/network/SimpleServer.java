package com.sunshinevvv.thinkinginjava.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Server start....");
            // 收消息
            Socket s = ss.accept();
            System.out.println("Client:" + s.getInetAddress().getLocalHost() + " connected");

            // 发消息
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String mess = br.readLine();
            System.out.println("Client message：" + mess);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write("Hello, I am Server.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
