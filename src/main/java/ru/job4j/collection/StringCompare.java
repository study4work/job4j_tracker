package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
            for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
                char first = left.charAt(i);
                char second = right.charAt(i);
                if (first != second) {
                    rsl = Character.compare(first, second);
                    break;
                }
                if (left.length() > right.length()) {
                    rsl = 1;
                }
                if (left.length() < right.length()) {
                    rsl = -1;
                }
        }
        return rsl;
    }
}