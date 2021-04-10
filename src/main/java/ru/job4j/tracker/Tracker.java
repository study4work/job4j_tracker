package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tracker {
//    private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    private static Tracker excess = null;

    public static Tracker getExcess() {
        if (excess == null) {
            excess = new Tracker();
        }
        return excess;
    }

    public Item add(Item item) {
        item.setId(ids ++);
        items.add(item);
        return item;
    }
//    public Item add(Item item) {
//        item.setId(ids++);
//        items[size++] = item;
//        return item;
//    }

    private int indexOf(int id) {
        int rsl = -1;
        for(Item item : items) {
            if(item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }
//    private int indexOf(int id) {
//        int rsl = -1;
//        for (int index = 0; index < size; index++) {
//            if (items[index].getId() == id) {
//                rsl = index;
//                break;
//            }
//        }
//        return rsl;
//    }
      public Item findById(int id) {
          int index = indexOf(id);
          return index != -1 ? items.get(index) : null;
      }
//    public Item findById(int id) {
//        int index = indexOf(id);
//        return index != -1 ? items[index] : null;
//    }

    public List<Item> findAll(){
        List<Item> item = new ArrayList<>();
        for(Item item1 : items) {
            if (item1 != null) {
                item.add(item1);
            }
        }
        return item;
    }
//    public Item[] findAll() {
//        Item[] item = new Item[items.length];
//        int size = 0;
//        for (int i = 0; i < items.length; i++) {
//            if (items[i] != null) {
//                item[size] = items[i];
//                size ++;
//            }
//        }
//        return Arrays.copyOf(item, size);
//    }
      public List<Item> findByName(String key){
        List<Item> item = new ArrayList<>();
        for(Item item1 : items) {
            if(item1.getName().equals(key)) {
                item.add(item1);
            }
        }
        return item;
      }
//    public Item[] findByName(String key) {
//         Item[] item = new Item[this.size];
//        int size = 0;
//        for (int i = 0; i < this.size; i++) {
//            if (items[i].getName().equals(key)) {
//                item[size] = items[i];
//                size ++;
//            }
//        }
//        return Arrays.copyOf(item, size);
//    }
      public  boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index >= 0) {
            items.set(index, item);
            rsl = true;
        }
        return rsl;
      }
//    public boolean replace(int id, Item item) {
//        boolean rsl = false;
//     int index = indexOf(id);
//     item.setId(id);
//     if (index >= 0) {
//         items[index] = item;
//         rsl = true;
//     }
//     return rsl;
//    }
      public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
      }
//    public boolean delete(int id) {
//        boolean rsl = false;
//        int index = indexOf(id);
//        if (index != - 1) {
//            items[index] = null;
//            System.arraycopy(items, index + 1, items, index, size - index);
//            items[size - 1] = null;
//            size--;
//            rsl = true;
//        }
//        return rsl;
//    }
}