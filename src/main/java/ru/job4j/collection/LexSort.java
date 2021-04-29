package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] first = left.split(" ");
        String[] second = right.split(" ");
        double one = Double.parseDouble(first[0]);
        double two = Double.parseDouble(second[0]);
       return Double.compare(one, two);
     }
}