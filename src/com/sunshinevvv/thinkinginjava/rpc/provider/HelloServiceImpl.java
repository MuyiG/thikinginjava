package com.sunshinevvv.thinkinginjava.rpc.provider;

import com.sunshinevvv.thinkinginjava.rpc.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
