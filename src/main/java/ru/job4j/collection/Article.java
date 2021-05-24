package ru.job4j.collection;

import java.util.*;

public class Article {
        /**
     * @param origin текст на вход
     * @param line   текст для проверки
     * @return true в случае,если line составлен из оригинального текста
     * добавляем в коллекцию элементы двух строк,результат основан на работе метода add,который
         * возвращает false в случае если елемент уже присутствует в коллекции.
         * В конце меняем местами результат работы метода.
     */
    public static boolean generateBy(String origin, String line) {
        boolean result = true;
        Set<String> compare = new HashSet<>();
        origin = origin.replaceAll("\\p{P}", "");
        String[] org = origin.split(" ");
        String[] ln = line.split(" ");

        for (int i = 0; i < org.length; i++) {
            compare.add(org[i]);
        }

        for (int i = 0; i < ln.length; i++) {
            result = compare.add(ln[i]);
            if (result) {
                break;
            }
        }
       result = result == false ? true : false;
        return result;

    }

}
