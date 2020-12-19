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

    public static int count (String name, int matches) {
            matches = matches - player(name);
            System.out.println("Осталось " + matches + " спичек");
        return matches;
    }

    public static void main (String[] args) {
        int matches = 11;
        String player1 = "Игрок 1";
        String player2 = "Игрок 2";
        String player = "";
        boolean winner = false;
        while (matches > 0) {
            winner = !winner;
            if (winner) {
                player = player1;
                matches = count(player, matches);
            } else {
                player = player2;
                matches = count(player,matches);
            }
    }
        System.out.println("Победитель " + player);
    }
}
