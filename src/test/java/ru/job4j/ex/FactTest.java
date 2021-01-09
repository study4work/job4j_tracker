package ru.job4j.ex;

import org.junit.Test;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenStartLessThen0() {
    Fact.calc(-3);
    }
}