package ru.job4j.oop;

public class Reduce {
    private int[] arrayTwo;

    public void to(int[] array) {
            arrayTwo = array;
    }

    public void print() {
        for (int index = 0; index < arrayTwo.length; index++) {
            System.out.println(arrayTwo[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}