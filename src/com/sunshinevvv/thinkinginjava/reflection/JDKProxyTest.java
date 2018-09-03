package com.sunshinevvv.thinkinginjava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface HelloWorld {
    void sayHello();
}

class HelloWorldImpl implements HelloWorld {
    public void sayHello() {
        System.out.println("hello world");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method :" + method.getName() + " is invoked!");
        return method.invoke(target, args);
    }
}

public class JDKProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 这里有两种写法，我们采用略微复杂的一种写法，这样更有助于大家理解。
        Class<?> proxyClass = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(), HelloWorld.class);
        final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
        final InvocationHandler ih = new MyInvocationHandler(new HelloWorldImpl());
        HelloWorld helloWorld = (HelloWorld) cons.newInstance(ih);
        helloWorld.sayHello();

        System.out.println("---");
        // 下面是更简单的一种写法，本质上和上面是一样的
        HelloWorld helloWorld2 = (HelloWorld) Proxy.
                newProxyInstance(JDKProxyTest.class.getClassLoader(),
                        new Class<?>[]{HelloWorld.class},
                        new MyInvocationHandler(new HelloWorldImpl()));
        helloWorld2.sayHello();
    }
}
