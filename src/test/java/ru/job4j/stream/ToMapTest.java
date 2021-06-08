package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ToMapTest {
    @Test
    public void whenListToMap() {
        ToMap map = new ToMap();
        Student student = new Student(12, "Ivanov");
        Student student1 = new Student(12, "Ivanov");
        Student student2 = new Student(13, "Sozonov");
        List<Student> list = List.of(student, student1, student2);
        Map<String, Student> rsl = map.map(list);
        Map<String, Student> expected = Map.of(student.getSurname(),
                                               student,
                                               student2.getSurname(),
                                               student2);
        assertThat(rsl, is(expected));
    }
}