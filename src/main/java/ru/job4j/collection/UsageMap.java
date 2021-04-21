package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main (String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("FaJlJleN@ya.ru", "Lysenko Alexander Vladimirovich");
        for (String key : map .keySet()) {
            String value = map .get(key);
            System.out.println(key + " = " + value);
        }
    }
}
