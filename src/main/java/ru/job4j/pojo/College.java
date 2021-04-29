package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alexandr Vladimirovich Lysenko");
        student.setGroupName("33g");
        student.setAdmission(new Date());

        System.out.println("Student "
                + student.getName()
                + " has admission in class "
                + student.getGroupName()
                + " on " + student.getAdmission());
    }
}
