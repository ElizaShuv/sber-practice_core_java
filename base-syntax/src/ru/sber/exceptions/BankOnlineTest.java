package ru.sber.exceptions;

public class BankOnlineTest {
    public static void main(String[] args) {

try {
        BankOnline bank = new BankOnline();
        String cardName1 = "1234 5678 9000 1234";
        bank.send(cardName1, 50_000.0);
        System.out.println();

        String cardName2 = "12ab 5678 9000 1234";
        bank.send(cardName2, 50_000.0);
        System.out.println();

        /*bank.send(cardName2, null);
        System.out.println(); */

        /*bank.send(null, 1_000.0);
        System.out.println();*/

        /*String cardName3 = "1222 2222 2222 2222";
        bank.send(cardName3, -10_000.0);
        System.out.println();*/

        /*String cardName4 = "1223 2223 2223 2222";
        bank.send(cardName4, 100_000.0);
        System.out.println(); */

        /*String cardName5 = "2222 2222 2222 2222";
       bank.send(cardName5, 10_000.0);
       System.out.println(); */

         } catch (InvalidCardNumberException invalidCardNumber) {
        System.out.println(invalidCardNumber.getMessage());
        invalidCardNumber.printStackTrace();
        } catch (NegativeTransferException negativeTransfer) {
        System.out.println(negativeTransfer.getMessage());
        negativeTransfer.printStackTrace();
        } catch (OutOfLimitTransferException limitTransfer) {
        System.out.println(limitTransfer.getMessage());
        limitTransfer.printStackTrace();
        } catch (NullInformationException nullInformation) {
        System.out.println(nullInformation.getMessage());
        nullInformation.printStackTrace();
        } catch (BlockedCardException blockedCard) {
        System.out.println(blockedCard.getMessage());
        blockedCard.printStackTrace();
        }
}
}
