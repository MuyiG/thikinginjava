package com.sunshinevvv.thinkinginjava.innerclass;

import com.sunshinevvv.thinkinginjava.Think;
import com.sunshinevvv.thinkinginjava.common.BasicModel;
import com.sunshinevvv.thinkinginjava.common.NonPublicConstrutor;

public class Tests {
    public static void main(String[] args) {
        Parcel2.Contents contents = new Parcel2().contents();

        // 可以通过这种方式来绕过protected构造函数的限制来构造实例。
        NonPublicConstrutor nonPublicConstrutor = new NonPublicConstrutor(){};
        Think s = new Think() {};
        BasicModel basicModel = new BasicModel("",0){};
    }
}
