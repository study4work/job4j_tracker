package ru.job4j.stream;

import ru.job4j.collection.StringCompare;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(st -> st != null)
                .sorted((left, right) -> Integer.compare(left.getSurname().length(), right.getSurname().length()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}