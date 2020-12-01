package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Fast Ride");
    }

    @Override
    public void speed() {
        System.out.println("300 mph");
    }
}
