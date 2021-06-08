package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
 public List<Integer> matrix(Integer[][] integers) {
     return Arrays.stream(integers).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList());
 }
}

