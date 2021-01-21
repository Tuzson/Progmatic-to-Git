package Treds_practice;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main started");
        EvenNumberPrinterThread evenThread = new EvenNumberPrinterThread();
        OddNumberPrinterThread oddRunnable = new OddNumberPrinterThread();
        evenThread.start();
        Thread oddThread = new Thread(oddRunnable);
        oddThread.start();
        evenThread.join();
        Thread.sleep(3000);
        System.out.println("main ended");

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
