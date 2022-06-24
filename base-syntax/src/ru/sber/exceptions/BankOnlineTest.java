package ru.sber.exceptions;

public class BankOnlineTest {
    public static void main(String[] args) {
        BankOnline bank = new BankOnline();

        String cardName1 = "1234 5678 9000 1234";
        bank.send(cardName1, 50_000.0);
        System.out.println();

        String cardName2 = "12ab 5678 9000 1234";
        bank.send(cardName2, 50_000.0);
        System.out.println();


        bank.send(cardName2, null);
        System.out.println();

        bank.send(null, 1_000.0);
        System.out.println();

        String cardName3 = "1222 2222 2222 2222";
        bank.send(cardName3, -10_000.0);
        System.out.println();

        String cardName4 = "1223 2223 2223 2222";
        bank.send(cardName4, 100_000.0);
        System.out.println();

        String cardName5 = "2222 2222 2222 2222";
        bank.send(cardName5, 10_000.0);
        System.out.println();
    }
}
