package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        boolean run = true;
        while (run) {
            int player1;
            int player2;
            do {
                System.out.println("Игрок 1,введите кол-во спичек от 1 до 3");
                 player1 = Integer.valueOf(input.nextLine());
            } while (player1 > 3 || player1 <= 0);

                matches -= player1;
                System.out.println("Осталось " + matches + " спичек");

            if (matches == 0) {
                System.out.println("Игрок 1 победил");
                break;
            }

            do {
                System.out.println("Игрок 2,введите кол-во спичек от 1 до 3");
                player2 = Integer.valueOf(input.nextLine());
            } while (player2 > 3 || player2 <= 0);

                matches -= player2;
                System.out.println("Осталось " + matches + " спичек");

            if (matches == 0) {
                System.out.println("Игрок 2 победил");
                break;
            }

        }
    }
}
