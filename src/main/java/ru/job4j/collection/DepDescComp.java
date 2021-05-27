package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] str1 = o1.split("/");
        String[] str2 = o2.split("/");
        int comp = str2[0].compareTo(str1[0]);
        return comp == 0 ? o1.compareTo(o2) : comp;
    }
}