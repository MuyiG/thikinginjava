package com.sunshinevvv.thinkinginjava.concurrency.simulation.car;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by sunshine on 2017/9/18.
 */
public class CarBuilder {
    public static void main(String[] args) throws Exception {
        LinkedBlockingDeque<Car> chassisQueue = new LinkedBlockingDeque<>(),
                finishingQueue = new LinkedBlockingDeque<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();
        exec.execute(new ChassisBuilder(chassisQueue));
        exec.execute(new EngineRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));
        exec.execute(new Assembler(chassisQueue, finishingQueue, robotPool));
        exec.execute(new Reporter(finishingQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}

class Car {
    private final int id;

    private boolean engine, driveTrain, wheels;

    public Car(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // 这几个方法为何synchronized？
    public synchronized void addEngine() {
        engine = true;
    }

    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    public synchronized String toString() {
        return "Car " + id + " [engine:" + engine + " driveTrain:" + driveTrain + " wheels:" + wheels + "]";
    }
}

class ChassisBuilder implements Runnable {
    private LinkedBlockingDeque<Car> carQueue;
    private int counter = 0;

    public ChassisBuilder(LinkedBlockingDeque<Car> carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(counter++);
                System.out.println("ChassisBuilder created " + c);
                carQueue.put(c);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}

class Assembler implements Runnable {
    private LinkedBlockingDeque<Car> chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    public Assembler(LinkedBlockingDeque<Car> cq, LinkedBlockingDeque<Car> fq, RobotPool rp) {
        chassisQueue = cq;
        finishingQueue = fq;
        robotPool = rp;
    }

    public Car car() {
        return car;
    }

    public CyclicBarrier barrier() {
        return barrier;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until chassis is available:
                car = chassisQueue.take();
                // Hire robots to perform work:
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await(); // Until the robots finish
                // Put car into finishingQueue for further work
                finishingQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Assembler via interrupt");
        } catch (BrokenBarrierException e) {
            // This one we want to know about
            throw new RuntimeException(e);
        }
        System.out.println("Assembler off");
    }
}

class Reporter implements Runnable {
    private LinkedBlockingDeque<Car> carQueue;

    public Reporter(LinkedBlockingDeque<Car> cq) {
        carQueue = cq;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(carQueue.take());
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Reporter via interrupt");
        }
        System.out.println("Reporter off");
    }
}

abstract class Robot implements Runnable {
    private RobotPool pool;

    public Robot(RobotPool p) {
        pool = p;
    }

    protected Assembler assembler;

    public Robot assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    private boolean engage = false;

    public synchronized void engage() {
        engage = true;
        notifyAll();
    }

    // The part of run() that’s different for each robot:
    abstract protected void performService();

    public void run() {
        try {
            powerDown(); // Wait until
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await(); // Synchronize
                // We’re done with that job...
                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        } catch (BrokenBarrierException e) {
            // This one we want to know about
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null; // Disconnect from the Assembler
        // Put ourselves back in the available pool:
        pool.release(this);
        while (engage == false)  // Power down
            wait();
    }

    public String toString() {
        return getClass().getName();
    }
}

class EngineRobot extends Robot {
    public EngineRobot(RobotPool pool) {
        super(pool);
    }

    protected void performService() {
        System.out.println(this + " installing engine");
        assembler.car().addEngine();
    }
}

class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    protected void performService() {
        System.out.println(this + " installing DriveTrain");
        assembler.car().addDriveTrain();
    }
}

class WheelRobot extends Robot {
    public WheelRobot(RobotPool pool) {
        super(pool);
    }

    protected void performService() {
        System.out.println(this + " installing Wheels");
        assembler.car().addWheels();
    }
}

class RobotPool {
    // Quietly prevents identical entries:
    private Set<Robot> pool = new HashSet<>();

    public synchronized void add(Robot r) {
        pool.add(r);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException {
        for (Robot r : pool)
            if (r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssembler(d);
                r.engage(); // Power it up to do the task
                return;
            }
        wait(); // None available
        hire(robotType, d); // Try again, recursively
    }

    public synchronized void release(Robot r) {
        add(r);
    }
}
