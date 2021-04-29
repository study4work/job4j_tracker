package ru.job4j.collection.search;


import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] array : list) {
            for (int numbers : array) {
                rsl.add(numbers);
            }
        }
        return rsl;
    }
}