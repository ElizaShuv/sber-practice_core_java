package ru.sber.base.syntax;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        int n = 1;
        while (n <= 3) {
            String ans = in.nextLine();
            switch (ans) {
                case "Тролейбус":
                    System.out.println("Правильно!");
                    System.exit(0);
                case "Сдаюсь":
                    System.out.println("Правильный ответ: тролейбус");
                    System.exit(0);
                default:
                    if (n<3){
                        System.out.println("Подумай ещё");
                        n++;}
                    else{
                        System.out.println("Попытки кончились. Правильный ответ: тролейбус");
                        System.exit(0);}
            }
        }
    }
}

