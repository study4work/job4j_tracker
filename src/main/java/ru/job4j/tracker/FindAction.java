package ru.job4j.tracker;

import java.util.List;

public class FindAction implements UserAction {
    private final Output out;

    public FindAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        for (int i = 0; i < items.size(); i++) {
            out.println(items.get(i));
        }
        return true;
    }
}
