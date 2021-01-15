package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException{
        int rsl = -1;
        for(int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            } else if (i == value.length - 1) {
                throw new ElementNotFoundException("Element not found");
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"key1", "key2", "key3"};
        try {
            int rsl = indexOf(value, "key");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
