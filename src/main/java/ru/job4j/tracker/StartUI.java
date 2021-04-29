package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. ");
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }
//    public void init(Input input, Tracker tracker, UserAction[] actions) {
//        boolean run = true;
//        while (run) {
//            this.showMenu(actions);
//            int select = input.askInt("Select: ");
//            if (select < 0 || select >= actions.length) {
//                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
//                continue;
//            }
//            UserAction action = actions[select];
//            run = action.execute(input, tracker);
//        }
//    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
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

        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = Tracker.getExcess();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new FindAction(output));
        actions.add(new FindByIdAction(output));
        actions.add(new FindByNameAction(output));
        actions.add(new ReplaceAction(output));
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
    }
//        Output output = new ConsoleOutput();
//        Input input = new ValidateInput(output, new ConsoleInput());
//        Tracker tracker = Tracker.getExcess();
//        UserAction[] actions = {
//                new CreateAction(output),
//                new FindAction(output),
//                new FindByIdAction(output),
//                new FindByNameAction(output),
//                new ReplaceAction(output),
//                new DeleteAction(output),
//                new ExitAction(output)
//        };
//        new StartUI(output).init(input, tracker, actions);
//    }
}
