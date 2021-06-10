package ru.job4j.stream;

import ru.job4j.tracker.StubOutput;

import javax.swing.*;

public class Car {
    private String brand;
    private String model;
    private int wheels;
    private int doors;
    private boolean isEngine;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", wheels=" + wheels +
                ", doors=" + doors +
                ", isEngine=" + isEngine +
                '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private int wheels;
        private int doors;
        private boolean isEngine;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        Builder buildDoors(int doors) {
            this.doors = doors;
            return this;
        }

        Builder buildIsEngine(boolean isEngine) {
            this.isEngine = isEngine;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.doors = doors;
            car.wheels = wheels;
            car.isEngine = isEngine;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildBrand("Toyota")
                .buildModel("Rav 4")
                .buildDoors(4)
                .buildWheels(4)
                .buildIsEngine(true)
                .build();
        System.out.println(car);
    }
}
