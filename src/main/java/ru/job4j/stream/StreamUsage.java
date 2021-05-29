package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    List<Integer> list = Arrays.asList(1,-2,3,-4,5,6);
    List<Integer> filter = list.stream().filter(
            integer -> integer > 0
            ).collect(Collectors.toList());
}
