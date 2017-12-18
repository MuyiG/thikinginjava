package com.sunshinevvv.thinkinginjava.strings;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncodeTest {
    public static void main(String[] args) {
        try {
            System.out.println(URLEncoder.encode("杨光:)", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
