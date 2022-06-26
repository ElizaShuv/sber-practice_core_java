package ru.sber.exceptions;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BankOnline {

    private boolean isBlockedCard(String cardNumber) {
        File cards = new File("base-syntax/src/ru/sber/exceptions/BlockedCards.txt");
        try (BufferedReader bufReader = new BufferedReader(new FileReader(cards))) {
            String blockedCard = bufReader.readLine();
            while (blockedCard != null) {
                blockedCard = blockedCard.replaceAll(" ", "");
                if (cardNumber.equals(blockedCard))
                    return true;
                blockedCard = bufReader.readLine();
            }
        } catch (IOException except) {
            System.out.println("При работе с файлом произошла ошибка");
            except.printStackTrace();
        }

        return false;
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void send(String cardNumber, Double money) throws NegativeTransferException, NullInformationException, InvalidCardNumberException, OutOfLimitTransferException, BlockedCardException{

            if (cardNumber == null) {
                throw new NullInformationException("Ошибка перевода: Не указан номер карты");
            }
            if (money == null) {
                throw new NullInformationException("Ошибка перевода: Не указана сумма перевода");
            }

            String cardNumberFormat = cardNumber.replaceAll(" ", "");
            if (cardNumberFormat.length() != 16 || !isNumber(cardNumberFormat)) {
                throw new InvalidCardNumberException("Ошибка перевода: Неправильно указан номер карты");
            }
            if (money < 0) {
                throw new NegativeTransferException("Ошибка перевода: Сумма перевода не может быть отрицательной");
            }
            if (money > 50_000) {
                throw new OutOfLimitTransferException("Ошибка перевода: Перевод не может привышать лимит 50.000");
            }
            if (isBlockedCard(cardNumberFormat)) {
                throw new BlockedCardException("Ошибка перевода: Карта заблокирована");
            }
            System.out.println(String.format("Перевод на карту (%s) выполнен. \nСумма перевода: %s", cardNumber, money));
    }
}
