package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
    System.out.println("Транспорт движестя");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Кол - во пассажиров" + passengers);
    }

    @Override
    public int price(int amount) {
        int fuel = amount * 45;
        return fuel;
    }
}
