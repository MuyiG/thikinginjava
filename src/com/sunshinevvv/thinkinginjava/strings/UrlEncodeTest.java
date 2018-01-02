package com.sunshinevvv.thinkinginjava.strings;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncodeTest {
    public static void main(String[] args) {
        try {
            System.out.println(URLEncoder.encode("杨光:)", "UTF-8"));
            System.out.println(URLEncoder.encode("b oo", "UTF-8").replace("+", "%20"));
            System.out.println(URLDecoder.decode("b+oo", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
