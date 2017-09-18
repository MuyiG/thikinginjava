package com.sunshinevvv.thinkinginjava.concurrency.simulation.car;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by sunshine on 2017/9/18.
 */
public class CarBuilder {
}

class Car {
    private final int id;

    private boolean engine, driveTrain, wheels;

    public Car(int id) {
        this.id = id;
    }
    public Car() {
        id = -1;
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
        return  "Car " + id + " [engine:" + engine + " driveTrain:" + driveTrain + " wheels:" + wheels + "]";
    }
}

class CarQueue extends LinkedBlockingDeque<Car> {}