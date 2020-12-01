package ru.job4j.oop;

public class CarPark {
    public static void main(String[] args) {
        Vehicle airbus567 = new Plane();
        Vehicle airbus568 = new Plane();
        Vehicle bus33 = new Bus();
        Vehicle atrain = new Train();

        Vehicle[] vehicles = new Vehicle[]{airbus567, airbus568, atrain, bus33};
        for (Vehicle v : vehicles) {
            v.move();
            v.speed();
        }
    }
}
