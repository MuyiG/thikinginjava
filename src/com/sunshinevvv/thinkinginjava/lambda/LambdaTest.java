package com.sunshinevvv.thinkinginjava.lambda;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;

public class LambdaTest {
    public static void main(String[] args) {
        Callable<Integer> c = () -> 42;
        PrivilegedAction<Integer> p = () -> 42;
    }
}
