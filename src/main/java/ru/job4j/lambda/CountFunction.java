package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountFunction {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> doubles = new ArrayList<>();
        for (int i = start; i < end; i++) {
            Double d = (double) i;
            doubles.add(func.apply(d));
        }
        return doubles;
    }
}
