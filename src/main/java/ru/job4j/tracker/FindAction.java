package ru.job4j.tracker;

public class FindAction implements UserAction {
    @Override
    public String name() {
        return "=== Find all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        return true;
    }
}
