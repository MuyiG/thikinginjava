package com.sunshinevvv.thinkinginjava.common;

/**
 * Created by sunshine on 2017/2/8.
 * 检验Java方法的值传递特性
 */
public class PassValue {
    public static void main(String[] args) {
        PassValue test = new PassValue();
        BasicModel model = new BasicModel("model", 1);
        test.f(model); // 调用时会复制一个当前的引用的值，传递过去。结果是原引用和复制品都指向同一个对象。
        System.out.println(model);
    }

    private void f(BasicModel model) {
        // 这里的model已经是复制品了
        model.setName("test"); // 因为复制品引用的也是同一个对象，实际调用的是对象方法，所以会产生副作用
        model = null; // 修改的是复制品，不会影响原件
    }

}
