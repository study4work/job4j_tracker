package ru.job4j.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
//            String start = value.split("/")[0];
//            for (String el : value.split("/")) {
//                tmp.add(start);
//                start = start + "/" + el;
//            }
            String [] str = value.split("/");
            for (int i = 0; i < str.length; i++) {
                if (i == 1) {
                    tmp.add(str[i - 1] + "/" + str[i]);
                } if (i == 2) {
                    tmp.add(str[i - 2] + "/" + str[i - 1] + "/" + str[i]);
                } else {
                    tmp.add(str[0]);
                }

            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
    }
}