package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] item = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                item[size] = items[i];
                size ++;
            }
        }
        return Arrays.copyOf(item, size);
    }

    public Item[] findByName(String key) {
         Item[] item = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (items[i].getName().equals(key)) {
                item[size] = items[i];
                size ++;
                break;
            }
        }
        return Arrays.copyOf(item, size);
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
     int index = indexOf(id);
     item.setId(id);
     if (index >= 0) {
         items[index] = item;
         rsl = true;
     }
     return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (items[index] != null) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }
}