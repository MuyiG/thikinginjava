package com.sunshinevvv.thinkinginjava.concurrency.simulation.bank;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunshine on 2017/9/14.
 */
// Read-only objects don’t require synchronization:
class Customer {
    private final int serviceTime;

    public Customer(int tm) {
        serviceTime = tm;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public String toString() {
        return "[" + serviceTime + "]";
    }
}

// Teach the customer line to display itself:
// 因为会被多线程并发访问，所以用了线程安全的ArrayBlockingQueue
class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    public String toString() {
        if (this.size() == 0)
            return "[Empty]";
        StringBuilder result = new StringBuilder();
        for (Customer customer : this)
            result.append(customer);
        return result.toString();
    }
}

// Randomly add customers to a queue:
class CustomerGenerator implements Runnable {
    private CustomerLine customers;
    private static Random rand = new Random(47);

    public CustomerGenerator(CustomerLine cq) {
        customers = cq;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}

class Teller implements Runnable, Comparable<Teller> {
    private static int counter = 0;
    private final int id = counter++;

    // Customers served during this shift:
    private int customersServed = 0;
    private CustomerLine customers;
    private boolean serving = true;

    public Teller(CustomerLine cq) {
        customers = cq;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime()); // 模拟服务的过程
                synchronized (this) {
                    customersServed++; // 会和TellerManager线程并发访问此字段，所以需要同步synchronized
                    while (!serving)
                        wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    // 这两个方法，会执行在TellerManager线程里，所以需要synchronized，否则会造成不一致
    public synchronized void doSomethingElse() {
        customersServed = 0;
        serving = false;
    }
    public synchronized void serveCustomerLine() {
        assert !serving : "already serving: " + this;
        serving = true;
        notifyAll();
    }

    public String toString() {
        return "T" + id;
    }

    // Used by priority queue: 这里也要synchronized？
    public synchronized int compareTo(Teller other) {
        return Integer.compare(customersServed, other.customersServed);
    }
}

class TellerManager implements Runnable {
    private ExecutorService exec;
    private CustomerLine customers;
    private int adjustmentPeriod;

    // 用两个Queue存储工作中的和空闲的Teller，但是PriorityQueue和LinkedList非线程安全？因为只有一个TellerManager线程会操作这两个Queue，所以不存在多线程并发问题。
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();

    public TellerManager(ExecutorService e, CustomerLine customers, int adjustmentPeriod) {
        exec = e;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;

        // Start with a single teller:
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    /**
     * This is actually a control system. By adjusting the numbers,
     * you can reveal stability issues in the control mechanism.
     */
    public void adjustTellerNumber() {
        // If line is too long, add another teller:
        if (customers.size() / workingTellers.size() > 2) {
            // If tellers are doing another job, bring one back:
            if (tellersDoingOtherThings.size() > 0) {
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }
            // Else create (hire) a new teller
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        // If line is short enough, remove a teller:
        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2) {
            reassignOneTeller();
        }
        // If there is no line, we only need one teller:
        if (customers.size() == 0) {
            while (workingTellers.size() > 1) {
                reassignOneTeller();
            }
        }
    }

    // Give a teller a different job or a break:
    private void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 每adjustmentPeriod ms 调整一次
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();

                // 输出结果
                System.out.print("CustomerLine:" + customers + " , Tellers: { ");
                for (Teller teller : workingTellers)
                    System.out.print(teller + " ");
                System.out.println("}");
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    public String toString() {
        return "TellerManager ";
    }
}

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 5;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // If line is too long, customers will leave: 但这里的实现还是会阻塞等待的啊
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE * 2);
        exec.execute(new CustomerGenerator(customers));
        // Manager will add and remove tellers as necessary:
        exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));

        System.out.println("Press ‘Enter’ to quit");
        System.in.read();
        exec.shutdownNow();
    }
}