package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Flight");
    }

    @Override
    public void speed() {
        System.out.println("Speed 200mph");
    }
}
