package com.sunshinevvv.thinkinginjava.innerclass;

/**
 * 定义在另一个类的文件里，作用域为default，仅同package的类可见。
 */
interface Selector {
    boolean end();

    Object current();

    void next();
}

/**
 * 简易的List
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    private class ReverseSequenceSelector implements Selector {
        private int i = items.length - 1;

        public boolean end() {
            return i < 0 ;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i >= 0) {
                i--;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        selector = sequence.reverseSelector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
