package com.sunshinevvv.thinkinginjava.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2011-2099</p>
 * <p>公   司： 口袋购物</p>
 * <p>其他说明：</p>
 * <p>作   者：杨光</p>
 * <p>完成日期：2018/6/14</p>
 */
public class HttpUrlTest {
    public static void main(String[] args) {
        // true
        System.out.println(containHttpUrl("https://blog.csdn.net/Bronna/article/details/77529145"));
        System.out.println(containHttpUrl("https://h5.weidian.com/m/weidian/customer-say.html?shopId=982706362"));
        System.out.println(containHttpUrl("lalalala https://blog.csdn.net/Bronna/article/details/77529145 asdwafwf"));
        System.out.println(containHttpUrl("lalalala盛大的 blog.CSDN.net/Bronna/article/details/77529145 asdwafwf"));
        System.out.println(containHttpUrl("lalalala盛大的 blog.CSDN.nete3r34 asdwafwf"));
        System.out.println(containHttpUrl("lalalala盛大的https://h5.weidian.com/m/weidian/customer-say.html?shopId=982706362sdwafwf"));
        System.out.println(containHttpUrl("lalalala盛大的https://weidian.com/?userid=1144549763"));

        // false
        System.out.println(containHttpUrl("lalalala盛大的 /Bronna/article/details/77529145 asdwafwf"));
        System.out.println(containHttpUrl("lalalala盛大的adwfwevasdwafwf"));
        System.out.println(containHttpUrl("lalalala盛大的/m/weidian/customer-say.html?shopId=982706362sdwafwf"));
    }

    /**
     * 判断字符串是否包含URL
     */
    public static boolean containHttpUrl(String source) {
        String regex = ".*(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?).*";//设置正则表达式
//        String regex = "[a-zA-Z]+://[^\\s]*";
        Pattern pat = Pattern.compile(regex.trim());//比对
        Matcher mat = pat.matcher(source.trim());
        return mat.matches();//判断是否匹配
    }
}
