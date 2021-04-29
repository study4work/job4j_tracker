package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("Item name");
        strings.add("1");
        Input in = new StubInput(
                strings
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("Item name");
        strings.add("1");
        strings.add("1");
        strings.add("Changed name");
        strings.add("2");
        Input input = new StubInput(
                strings
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new ReplaceAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Changed name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        List<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("1");
        strings.add("1");
        Input in = new StubInput(
                strings
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new DeleteAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        Item item1 = null;
        assertThat(tracker.findById(item.getId()), is(item1));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("0");
        Input in = new StubInput(
                strings
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. == Exit ==" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("Item");
        strings.add("1");
        strings.add("1");
        strings.add("2");
        Input in = new StubInput(
                strings
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
               actions.add(new CreateAction(out));
               actions.add(new FindByIdAction(out));
               actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                        + "0. === Create a new Item ====" + System.lineSeparator()
                        + "1. == Find by Id ==" + System.lineSeparator()
                        + "2. == Exit ==" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ====" + System.lineSeparator()
                        + "1. == Find by Id ==" + System.lineSeparator()
                        + "2. == Exit ==" + System.lineSeparator()
                        + "Item{id=1, name='Item'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ====" + System.lineSeparator()
                        + "1. == Find by Id ==" + System.lineSeparator()
                        + "2. == Exit ==" + System.lineSeparator()
                ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("Item");
        strings.add("1");
        strings.add("Item");
        strings.add("2");
        Input in = new StubInput(
                strings
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new FindByNameAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Create a new Item ====" + System.lineSeparator()
                + "1. == Find by Name ==" + System.lineSeparator()
                + "2. == Exit ==" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Create a new Item ====" + System.lineSeparator()
                + "1. == Find by Name ==" + System.lineSeparator()
                + "2. == Exit ==" + System.lineSeparator()
                + "Item{id=1, name='Item'}" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Create a new Item ====" + System.lineSeparator()
                + "1. == Find by Name ==" + System.lineSeparator()
                + "2. == Exit ==" + System.lineSeparator()));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("1");
        Input in = new StubInput(
                strings
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new FindAction(out));
                actions.add(new ExitAction(out));
        Item item = tracker.add(new Item("Item"));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                        + "0. === Find all items ===" + System.lineSeparator()
                        + "1. == Exit ==" + System.lineSeparator()
                        + "Item{id=1, name='Item'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find all items ===" + System.lineSeparator()
                        + "1. == Exit ==" + System.lineSeparator()
                ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("-1");
        strings.add("0");
        Input in = new StubInput(
                strings
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. == Exit ==%n"
                                + "Wrong input, you can select: 0 .. %n"
                                + "Menu.%n"
                                + "0. == Exit ==%n"
                )
        ));
    }
}