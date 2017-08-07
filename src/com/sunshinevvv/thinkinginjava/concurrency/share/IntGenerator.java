package com.sunshinevvv.thinkinginjava.concurrency.share;

public abstract class IntGenerator {

    // volatile?
    private volatile boolean canceled = false;

    public abstract int next();

    // Allow this to be canceled:
    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
