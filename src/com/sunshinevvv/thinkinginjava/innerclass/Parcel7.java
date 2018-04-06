package com.sunshinevvv.thinkinginjava.innerclass;

import com.sunshinevvv.thinkinginjava.common.BasicModel;

/**
 * 匿名内部类的用法
 */
public class Parcel7 {
    // 内部类引用到的成员变量不需要声明为final
    private int j = 2;
    BasicModel model = new BasicModel("field", 3);

    public Contents contents() {
        // 内部类引用到的方法内的局部变量必须声明为final
        final int k = 4;
        final BasicModel localModel = new BasicModel("local", 7);

        return new Contents() { // Insert a class definition
            private int i = 1;

            public int value() {
                System.out.println("i=" + i + ", j=" + j + ", k=" + k);
                System.out.println("model:" + model.getName() + " " + model.getNo());
                System.out.println("localModel" + localModel.getName() + " " + localModel.getNo());
                return i + j + k;
            }
        };
    }

    public void setJ(int j) {
        this.j = j;
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        c.value();
        p.model.setNo(4);
        p.setJ(5);
        c.value();
    }
}