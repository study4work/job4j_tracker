package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "== Find by Name ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name item you want to find");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                out.println(items.get(i)); }
        } else {
            out.println("Items doesn't find");
        }
        return true;
    }
}
