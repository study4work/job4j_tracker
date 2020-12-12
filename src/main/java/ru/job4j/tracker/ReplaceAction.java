package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter replace id: ");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Your item has been changed: ");
        } else {
            System.out.println("Your item hasn't been changed");
        }
        return true;
    }
}
