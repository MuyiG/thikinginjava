package com.sunshinevvv.thinkinginjava.innerclass;

public class DotNew {
    public class Inner {}
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        Inner dni = dn.new Inner();
    }
}
