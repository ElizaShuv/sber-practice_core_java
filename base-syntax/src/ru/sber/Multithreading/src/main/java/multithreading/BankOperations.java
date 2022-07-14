package multithreading;

public class BankOperations implements Runnable {
    private Account account = new Account();

    private synchronized void makeWithdrawal(int outSum) {
        System.out.println(Thread.currentThread().getName() + " хочет вывести средства");
        if (account.getBalance() >= outSum) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            account.withdraw(outSum);
            System.out.println(String.format("%s вывод средств завершен. Текущий баланс: %s", Thread.currentThread().getName(), account.getBalance()));
        } else {
            System.out.println(String.format("Недостаточно средств на счете %s. Баланс: %s", Thread.currentThread().getName(), account.getBalance()));
        }
    }

    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
        }
    }
}