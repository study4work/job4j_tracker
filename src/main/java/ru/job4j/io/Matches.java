package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static int player (String name) {
        Scanner input = new Scanner(System.in);
        int player;
            do {
                System.out.println(name + " введите кол-во спичек от 1 до 3");
                player = Integer.valueOf(input.nextLine());
            } while (player > 3 || player <= 0);
            return player;
    }

    public static void main (String[] args) {
        int matches = 11;
        while (matches > 0) {
            int player1 = player("Игрок 1");
                matches -= player1;
                System.out.println("Осталось " + matches + " спичек");
            if (matches == 0) {
                System.out.println("Игрок 1 победил");
                break;
            }
            int player2 = player("Игрок 2");
                matches -= player2;
                System.out.println("Осталось " + matches + " спичек");
            if (matches == 0) {
                System.out.println("Игрок 2 победил");
                break;
            }
        }
    }
}
