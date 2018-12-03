package com.sunshinevvv.thinkinginjava.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class SystemPropertyTest {
    public static void main(String[] args) {
        System.out.println("打印 系统属性...");
        Properties props = System.getProperties();
        for (Iterator<Object> it = props.keySet().iterator(); it.hasNext();){
            String key = (String)it.next();
            String value = (String)props.get(key);
            System.out.println(key+"\t"+value);
        }
        System.out.println("打印 环境变量...");
        Map<String,String> map = System.getenv();
        for (Iterator<String> it = map.keySet().iterator();it.hasNext();){
            String key = it.next();
            String value = map.get(key);
            System.out.println(key+"\t"+value);
        }
    }
}
