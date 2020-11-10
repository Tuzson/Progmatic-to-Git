package com.company;

import java.util.Stack;

public class Rekurzió {
    public static void main(String[] args) {


//        int factNr = 5;
//        System.out.println(fact(factNr));
//        int fiboNr = 10;
//        System.out.println(fiboRec(fiboNr));
//        System.out.println(fiboIter(fiboNr));

//        for (int i = 0; i < fiboNr; i++) {
//            System.out.print((i) + "+" + (i + 1) + " = " + fibo(i));
//            System.out.println();
//        }

        System.out.println(fiboStack(45));

    }

    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return (n * fact(n - 1));
        }
    }

    public static int fiboRec(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return (fiboRec(n - 1) + fiboRec(n - 2));
        }
    }

    public static long fiboIter(int n) {
        long nrAct = 0;
        long nrPrev = 0;
        long nrPrev2 = 1;

        for (int i = 0; i < n; i++) {
            nrAct = nrPrev2 + nrPrev;
            nrPrev2 = nrPrev;
            nrPrev = nrAct;
        }
        return nrAct;
    }

    public static long fiboStack(int n) {
        long sum = 0;
        Stack<Integer> fiboStack = new Stack<>();
        fiboStack.push(n);
        while (!fiboStack.isEmpty()) {
            int nr = fiboStack.pop();
            if (nr == 1 || nr == 0) {
                sum += nr;
            } else {
                fiboStack.push(nr - 1);
                fiboStack.push(nr - 2);
            }

        }
        return sum;
    }
}
