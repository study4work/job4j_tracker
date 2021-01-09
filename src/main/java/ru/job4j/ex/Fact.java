package ru.job4j.ex;

public class Fact {
    public static int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("n should be more then 0");
        }
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
    public static void main(String[] args) {
        System.out.println("Factorial is:" + calc(-1));
    }
}
