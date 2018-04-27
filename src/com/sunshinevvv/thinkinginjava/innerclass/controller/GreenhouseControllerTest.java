package com.sunshinevvv.thinkinginjava.innerclass.controller;

public class GreenhouseControllerTest {
    public static void main(String[] args) {
        GreenhouseController gc = new GreenhouseController();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        gc.addEvent(new GreenhouseController.Terminate(10000));
        gc.run();
    }
}
