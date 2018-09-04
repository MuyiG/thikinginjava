package com.sunshinevvv.thinkinginjava.rpc;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
