package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        /* if contains throw ElementAbuseException */
        boolean rsl = false;
        for (int i = 0; i < abuses.length; i++) {
            if (value.equals(abuses[i])) {
                throw new ElementAbuseException("Element abuse");
            }
            rsl = true;
        }
        return rsl;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
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
