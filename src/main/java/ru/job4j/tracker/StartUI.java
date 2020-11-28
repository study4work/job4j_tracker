package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Find all items ===");
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i]);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Enter replace id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Your item has been changed: ");
                } else {
                System.out.println("Your item hasn't been changed"); }
            } else if (select == 3) {
                System.out.println("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Your id has been delete");
                } else {
                    System.out.println("Your id hasn't delete"); }
            } else if (select == 4) {
                System.out.println("Enter id item you want to find");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Item doesn't find");
                }
            } else if (select == 5) {
                System.out.println("Enter name item you want to find");
                Scanner input = new Scanner(System.in);
                String name = input.nextLine();
                Item[] items = tracker.findByName(name);
                for (int i = 0; i < items.length; i++) {
                    if (items[i].getName().equals(name)) {
                        System.out.println(items[i]);
                    } else {
                        System.out.println("Items doesn't find");
                    }
                }
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


        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);


    }
}
