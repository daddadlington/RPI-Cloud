package com.ruddlesdin;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #00 as output
        final GpioPinDigitalOutput pin15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "Pin15", PinState.LOW);

        // provision gpio pin #01 as output
        final GpioPinDigitalOutput pin16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "Pin16", PinState.LOW);

        System.out.println("<--Pi4J--> GPIO Control Example ... started.");
        pin15.setShutdownOptions(true, PinState.LOW);
        pin16.setShutdownOptions(true, PinState.LOW);

        while(true) {
            System.out.println("Set pin15 high and pin16 low");
            pin15.high();
            pin16.low();
            Thread.sleep(2000);
            System.out.println("Set pin15 low and pin16 high");
            pin15.low();
            pin16.high();
            Thread.sleep(2000);
        }

    }
}
