package ru.job4j.oop;

public class Bus implements Vehicle{
    @Override
    public void move() {
        System.out.println("Ride");
    }

    @Override
    public void speed() {
        System.out.println("100 mph");
    }
}
