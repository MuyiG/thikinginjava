package com.sunshinevvv.thinkinginjava.rpc.provider;

import com.sunshinevvv.thinkinginjava.rpc.RpcFramework;
import com.sunshinevvv.thinkinginjava.rpc.api.HelloService;

public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
