package com.sunshinevvv.thinkinginjava.concurrency.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MultiThreadInfiLoop {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.submit(new Runnable() {
                @Override
                public void run() {
//                    int j = 0;
//                    while (true) {
//                        j++;
//                    }
                    while (true) {
                        File file = new File("/Users/sunshine/Documents/formatter.xml");
                        try {
                            FileReader reader = new FileReader(file);
                            reader.read();
                            reader.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
