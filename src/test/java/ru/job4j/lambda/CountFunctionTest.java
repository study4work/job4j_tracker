package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class CountFunctionTest {
    CountFunction function = new CountFunction();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x,2) + 2);
        List<Double> expected = Arrays.asList(27D, 38D, 51D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDoubleFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x,x));
        List<Double> expected = Arrays.asList(3125D, 46656D, 823543D);
        assertThat(result, is(expected));
    }
}