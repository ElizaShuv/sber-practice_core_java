package multithreading;

import org.junit.Test;

public class TestMultithreading {

    private static final Thread THREAD = new ItThread();
    private static final Thread RUNNABLE = new Thread(new ItRunnable());

    @Test
    public void firstTest() {
        THREAD.start();
        RUNNABLE.start();
    }

    @Test
    public void secondTest() throws Exception {
        Thread newThread = new Thread(() -> System.out.println("Побочный поток"));
        newThread.start();
        newThread.join();
        THREAD.start();
    }

    @Test
    public void thirdTest() {
        Thread newThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Побочный поток");
        });
        newThread.setDaemon(true);
        newThread.start();
        System.out.println("Главный поток");
    }

    @Test
    public void fourthTest() throws Exception {
        BankOperations bankOperations = new BankOperations();
        Thread one = new Thread(bankOperations);
        Thread two = new Thread(bankOperations);
        one.setName("Клиент 1");
        two.setName("Клиент 2");
        one.start();
        one.join();
        two.start();
    }

    @Test
    public void fifthTest() throws Exception {
        Object object = new Object();
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    synchronized (object) {
                        System.out.println("Побочный поток выполнен");
                        object.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        synchronized (object) {
            object.wait();
        }
    }

    @Test
    public void sixthTest() throws Exception {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(2490);
                    System.out.println("Побочный поток");
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("Основной поток выполнен");
    }
}
