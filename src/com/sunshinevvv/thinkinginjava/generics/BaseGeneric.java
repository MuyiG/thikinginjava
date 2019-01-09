package com.sunshinevvv.thinkinginjava.generics;

public class BaseGeneric<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseGeneric(T data) {
        this.data = data;
    }
}
