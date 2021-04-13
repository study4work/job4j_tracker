package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

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

    private int indexOf(int id) {
        int rsl = -1;
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

      public Item findById(int id) {
          int index = indexOf(id);
          return index != -1 ? items.get(index) : null;
      }

    public List<Item> findAll(){
        return List.copyOf(items);
    }

      public List<Item> findByName(String key){
        List<Item> item = new ArrayList<>();
        for(Item item1 : items) {
            if(item1.getName().equals(key)) {
                item.add(item1);
            }
        }
        return item;
      }

      public  boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index >= 0) {
            items.set(index, item);
            rsl = true;
        }
        return rsl;
      }

      public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
      }
}