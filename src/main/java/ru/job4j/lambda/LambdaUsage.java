package ru.job4j.lambda;

import java.util.Arrays;
        import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.getName() + " : " + right.getName());
            return right.getName().compareTo(left.getName());
        };
        Arrays.sort(atts, cmpDescSize);
        for (Attachment at : atts) {
            System.out.println(at);
        }
    }

}