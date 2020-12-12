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
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Input input = new StubInput(
                new String[] {"0", "Item name", "1", "1", "Changed name", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Changed name"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        Item item1 = null;
        assertThat(tracker.findById(item.getId()), is(item1));
    }
}