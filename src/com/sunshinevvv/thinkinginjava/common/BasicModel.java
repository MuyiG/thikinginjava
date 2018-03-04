package com.sunshinevvv.thinkinginjava.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunshine on 2017/2/8.
 * 测试用基本Model
 */
public class BasicModel {
    public static final int CONST_INT = 1;

    private String name;
    private int no;

    public BasicModel(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public String toString() {
        return name + "-" + no;
    }

    public static List<BasicModel> createModel(int num) {
        List<BasicModel> result = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            result.add(new BasicModel("Model" + i, i));
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
