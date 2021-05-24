package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int comp = o1.compareTo(o2);
        if (comp == 0) {
            comp = o2.compareTo(o1);
        }
        return comp;
    }
}