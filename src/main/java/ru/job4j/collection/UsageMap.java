package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main (String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("FaJlJleN@ya.ru", "Lysenko Alexander Vladimirovich");
        for (Map.Entry<String, String> entry : map.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        System.out.println(key + " " + value);
        }
    }
}
