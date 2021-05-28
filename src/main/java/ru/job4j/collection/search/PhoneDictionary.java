package ru.job4j.collection.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
//    public ArrayList<Person> find(String key) {
//        ArrayList<Person> result = new ArrayList<>();
//        for (Person person : persons) {
//            if (person.getName().contains(key) || person.getSurname().contains(key)
//            || person.getAddress().contains(key) || person.getPhone().contains(key)) {
//                result.add(person);
//            }
//        }
//        return result;
//    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = pr -> pr.getName().contains(key) || pr.getSurname().contains(key)
                                 || pr.getAddress().contains(key) || pr.getPhone().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
