package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.getTime().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);

        Item userFirst = new Item(1,"Alex");
        Item userSecond = new Item(2);
    }
}
