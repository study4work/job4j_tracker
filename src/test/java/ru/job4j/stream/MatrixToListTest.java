package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void whenListToMap() {
        MatrixToList matrix = new MatrixToList();
        Integer[][] array = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> rsl = matrix.matrix(array);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(rsl, is(expected));
    }
}