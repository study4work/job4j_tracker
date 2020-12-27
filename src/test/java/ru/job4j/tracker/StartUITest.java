package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.security.SecureRandom;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "Item name", "1", "1", "Changed name", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Changed name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        Item item1 = null;
        assertThat(tracker.findById(item.getId()), is(item1));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. == Exit ==" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","Item","1","1","2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. === Create a new Item ====" + System.lineSeparator() +
                "1. == Find by Id ==" + System.lineSeparator() +
                "2. == Exit ==" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. === Create a new Item ====" + System.lineSeparator() +
                "1. == Find by Id ==" + System.lineSeparator() +
                "2. == Exit ==" + System.lineSeparator() +
                "Item{id=1, name='Item'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. === Create a new Item ====" + System.lineSeparator() +
                "1. == Find by Id ==" + System.lineSeparator() +
                "2. == Exit ==" + System.lineSeparator()
                ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","Item","1","Item","2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. === Create a new Item ====" + System.lineSeparator() +
                "1. == Find by Name ==" + System.lineSeparator() +
                "2. == Exit ==" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. === Create a new Item ====" + System.lineSeparator() +
                "1. == Find by Name ==" + System.lineSeparator() +
                "2. == Exit ==" + System.lineSeparator() +
                "Item{id=1, name='Item'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. === Create a new Item ====" + System.lineSeparator() +
                "1. == Find by Name ==" + System.lineSeparator() +
                "2. == Exit ==" + System.lineSeparator()));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindAction(out),
                new ExitAction(out)
        };
        Item item = tracker.add(new Item("Item"));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. === Find all items ===" + System.lineSeparator() +
                "1. == Exit ==" + System.lineSeparator() +
                "Item{id=1, name='Item'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. === Find all items ===" + System.lineSeparator() +
                "1. == Exit ==" + System.lineSeparator()
                ));
    }
}