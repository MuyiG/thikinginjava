package com.sunshinevvv.thinkinginjava.strings;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunshine on 2017/2/24.
 */
public class Regx {
    public static void main(String[] args) {
//        blockWords();
        match("Haha");
        match("Y0002");
        match("H00378");
        match("B890809");
        match("X87981739dhkj2");
        match("H");
        match("YH9930304");
    }

    private static void blockWords() {
        List<String> words = Arrays.asList("毛泽东", "江泽民", "习近平");
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (String temp : words) {
            sb.append(temp).append('|');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        String pattern = sb.toString();
        System.out.println(pattern);

        String s = "毛泽东哈哈哈哈哈江泽民呵呵呵呵习近平一员8元9河南科技比较好社保局开发板上课";
        Matcher matcher = Pattern.compile(pattern).matcher(s);
        if (matcher.find()) {
            s = matcher.replaceAll("***");
        }
        System.out.println(s);
    }

    public static void match(String s) {
        Pattern pattern = Pattern.compile("^(H|B|X)\\d+$");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            System.out.println("find " + s);
        } else {
            System.out.println("can't find " + s);
        }
    }
}
