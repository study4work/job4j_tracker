package ru.job4j.collection;

import java.util.HashSet;

    public class UsageHashSet {
        public static void main(String[] args) {
            HashSet<String> autos = new HashSet<String>();
            autos.add("BMW");
            autos.add("Toyota");
            autos.add("Lada");
            autos.add("Volvo");
            for (String cars : autos) {
                System.out.println(cars);
            }
        }
    }
