package Treds_practice;

public class CounterThread extends Thread {

    int startIdx;
    int endIdx;
    int[] toSum;
    double sum = 0;

    public CounterThread(int startIdx, int endIdx, int[] toSum) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.toSum = toSum;
    }

    @Override
    public void run() {
     getSum();

    }

    public void getSum() {
        for (int i = startIdx; i < endIdx; i++) {
            sum += Math.sin(toSum[i]);
        }
    }
}
