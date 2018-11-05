package com.sunshinevvv.thinkinginjava.network;

import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://h5.daily.weidian.com/m/weidian/attention-news.html?feedId=1722195#/news");
        System.out.println("URL 是 " + url.toString());
        System.out.println("协议是 " + url.getProtocol());
        System.out.println("主机是 " + url.getHost());
        System.out.println("文件名是 " + url.getFile());
        System.out.println("路径是 " + url.getPath());
        System.out.println("端口号是 " + url.getPort());
        System.out.println("默认端口号是 "
                + url.getDefaultPort());
        System.out.println("Query: " + url.getQuery());
        System.out.println("Ref: " + url.getRef());
    }
}
