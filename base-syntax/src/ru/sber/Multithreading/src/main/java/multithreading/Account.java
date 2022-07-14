package multithreading;

public class Account {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int outSum) {
        balance -= outSum;
    }
}
