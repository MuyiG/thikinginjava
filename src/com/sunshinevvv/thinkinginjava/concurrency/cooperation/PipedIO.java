package com.sunshinevvv.thinkinginjava.concurrency.cooperation;

import java.util.Random;
import java.util.concurrent.*;

class Sender implements Runnable {
    private Random rand = new Random(47);
//    private PipedWriter out = new PipedWriter();
//    public PipedWriter getPipedWriter() { return out; }

    private BlockingQueue<Character> queue;

    public Sender(BlockingQueue<Character> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while(true)
                for(char c = 'A'; c <= 'z'; c++) {
//                out.write(c);
                    queue.add(c);
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
            }
        }  catch(InterruptedException e) {
            System.out.println(e + " Sender sleep interrupted");
        }
    }
}
class Receiver implements Runnable {
//    private PipedReader in;
//    public Receiver(Sender sender) throws IOException {
//        in = new PipedReader(sender.getPipedWriter());
//    }

    private BlockingQueue<Character> queue;

    public Receiver(BlockingQueue<Character> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while(true) {
                // Blocks until characters are there:
                System.out.print("Read: " + queue.take() + ", ");
            }
        } catch(InterruptedException e) {
            System.out.println(e + " Receiver interrupted");
        }
    }
}
public class PipedIO {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Character> queue = new LinkedBlockingQueue<>();
        Sender sender = new Sender(queue);
        Receiver receiver = new Receiver(queue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
} 
