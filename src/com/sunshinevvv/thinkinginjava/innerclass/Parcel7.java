package com.sunshinevvv.thinkinginjava.innerclass;

import com.sunshinevvv.thinkinginjava.common.BasicModel;

/**
 * 匿名内部类的用法
 */
public class Parcel7 {
    // 内部类引用到的成员变量不需要声明为final，因为内部类包含外部类实例的引用，可以通过引用获取到成员变量，capture-by-reference方式，没有同步问题。
    private int j = 2;
    BasicModel model = new BasicModel("field", 3);
    private static int l = 0;

    public Contents contents() {
        // 内部类引用到的方法内的局部变量必须声明为final，因为这里的变量访问是通过capture-by-value的方式进行的，无法进行同步，Java为了省事直接强制城final了。
        final int k = 4;
        final BasicModel localModel = new BasicModel("local", 7);

        return new Contents() { // Insert a class definition
            private int i = 1;

            public int value() {
                System.out.println("i=" + i + ", j=" + j + ", k=" + k + ", l=" + l);
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