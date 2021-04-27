package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.ConvertList2Array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompareByIdTest {
    @Test
    public void byAscending() {
        List<Item> list = Arrays.asList(
                new Item(2,"Petr"),
                new Item(3,"Ivan"),
                new Item(4,"Alex"),
                new Item(1,"Petr")
                );

        Collections.sort(list,new CompareByIdAscending());
        List<Item> expect = Arrays.asList(
                new Item(1,"Petr"),
                new Item(2,"Petr"),
                new Item(3,"Ivan"),
                new Item(4,"Alex")
        );
        assertThat(list.get(0).getId(), is(expect.get(0).getId()));
    }

    @Test
    public void byDescending() {
        List<Item> list = Arrays.asList(
                new Item(2,"Petr"),
                new Item(3,"Ivan"),
                new Item(4,"Alex"),
                new Item(1,"Petr")
        );

        Collections.sort(list,new CompareByIdDescending());
        List<Item> expect = Arrays.asList(
                new Item(4,"Alex"),
                new Item(3,"Ivan"),
                new Item(2,"Petr"),
                new Item(1,"Petr")
        );
        assertThat(list.get(0).getId(), is(expect.get(0).getId()));
    }

}