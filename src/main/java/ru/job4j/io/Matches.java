package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static int player(String name) {
        Scanner input = new Scanner(System.in);
        int player;
        do {
            System.out.println(name + " введите кол-во спичек от 1 до 3");
            player = Integer.valueOf(input.nextLine());
        } while (player > 3 || player <= 0);
        return player;
    }

    public static int count(String name, int matches) {
            matches = matches - player(name);
            System.out.println("Осталось " + matches + " спичек");
        return matches;
    }

    public static void main(String[] args) {
        int matches = 11;
        boolean flag = false;
        String player = "";
        String player1 = "Игрок 1";
        String player2 = "Игрок 2";
        while (matches > 0) {
            flag = !flag;
            player = flag ? player1 : player2;
            matches = count(player, matches);
        }
        System.out.println("Победитель " + player);
    }
}
