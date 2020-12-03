package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAll(Tracker tracker) {
        System.out.println("=== Find all items ===");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public static void replace (Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter replace id: ");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Your item has been changed: ");
        } else {
            System.out.println("Your item hasn't been changed"); }
    }

    public static void delete (Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Your id has been delete");
        } else {
            System.out.println("Your id hasn't delete"); }
    }

    public static void findById (Input input, Tracker tracker) {
        int id = input.askInt("Enter id item you want to find");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item doesn't find");
        }
    }

    public static void findByName (Input input, Tracker tracker) {
        String name = input.askStr("Enter name item you want to find");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]); }
        } else {
            System.out.println("Items doesn't find");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select number: ");
            if (select == 0) {
               createItem(input,tracker);
            } else if (select == 1) {
                findAll(tracker);
            } else if (select == 2) {
                replace(input, tracker);
            } else if (select == 3) {
            delete(input, tracker);
            } else if (select == 4) {
                findById(input, tracker);
            } else if (select == 5) {
               findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    public static void main(String[] args) {

        /*Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.getTime().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);

        Item item1 = new Item();
        System.out.println(item1);

        Tracker tracker = new Tracker();
        tracker.add(item1);
        Item rsl = tracker.findById(1);
        System.out.println(rsl);*/


        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);


    }
}
