package Treds_practice;

import java.util.ArrayList;

public class ParalellCalculator {

    CounterThread counterThread;

    public double sumArrayParalelly(int[] arr, int nrOfProcess) throws InterruptedException {
       long l1 = System.currentTimeMillis();
        ArrayList<CounterThread> counterThreads = new ArrayList<>();
        double result = 0;
        int nr = arr.length / nrOfProcess;
        int nrBefore = 0;
        for (int i = 1; i <= nrOfProcess; i++) {
            counterThreads.add(new CounterThread(nrBefore, (nr * i), arr));
            nrBefore += nr;
        }
        for (int i = 0; i < counterThreads.size(); i++) {
            counterThreads.get(i).start();

        }
        for (int i = counterThreads.size() - 1; 0 <= i; i--) {
            counterThreads.get(i).join();
            result += counterThreads.get(i).sum;
        }
        long l2 = System.currentTimeMillis();
        System.out.println("Paralell: " + (l2-l1));
        return result;
    }

    public double sumArraySequential(int[] arr) {
        long l1 = System.currentTimeMillis();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.sin(arr[i]);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("Sequential: " + (l2-l1));
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[400000000];
        for (int i = 0; i < 400000000; i++) {
            arr[i] = i;
        }

        ParalellCalculator paralellCalculator = new ParalellCalculator();
        double sumPar = paralellCalculator.sumArrayParalelly(arr, 8);
        System.out.println(sumPar);
        double sumSeq = paralellCalculator.sumArraySequential(arr);
        System.out.println(sumSeq);
    }
}