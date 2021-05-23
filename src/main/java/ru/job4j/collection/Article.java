package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Article {
    /**
     *
     * @param origin текст на вход
     * @param line текст для проверки
     * @return true в случае,если line составлен из оригинального текста
     * сравниваем попарно елементы из двух списков,в случае если они равны,прерываем второй цикл,
     * для начала сравнения следующей пары и сохранения значения true при последней итерации
     */
    public static boolean generateBy(String origin, String line) {
        boolean result = false;
        List<String> org = Arrays.asList(origin.split(" "));
        List<String> ln = Arrays.asList(line.split(" "));
        for (String first : org) {
           for (String second : ln) {
               result = first.contains(second);
               if (result) {
                   break;
               }
           }
        }
        return result;
    }
}