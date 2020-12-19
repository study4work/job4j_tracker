package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
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
        UserAction[] actions = {
                new CreateAction(),
                new FindAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }


}
