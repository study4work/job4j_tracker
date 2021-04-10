package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("1");
        Input in = new StubInput(
                strings
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputOne() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("1");
        Input in = new StubInput(
                strings
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputFewAnswers() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("2");
        strings.add("2");
        strings.add("3");
        Input in = new StubInput(
                strings
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenInvalidInputNegative() {
        Output out = new StubOutput();
        List<String> strings = new ArrayList<>();
        strings.add("-1");
        Input in = new StubInput(
                strings
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}