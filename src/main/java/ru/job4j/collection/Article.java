package ru.job4j.collection;

import java.util.*;

public class Article {
        /**
     * @param origin текст на вход
     * @param line   текст для проверки
     * @return true в случае,если line составлен из оригинального текста
     */
    public static boolean generateBy(String origin, String line) {
        boolean result = true;
        Set<String> compare = new HashSet<>();
        origin = origin.replaceAll("\\p{P}", "");
        String[] org = origin.split(" ");
        String[] ln = line.split(" ");

        for (String originalString : org) {
            compare.add(originalString);
        }
        for (String lineString : ln) {
            if (!compare.contains(lineString)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
