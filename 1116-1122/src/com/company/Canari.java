package com.company;

public class Canari extends Bird {

    public Canari(String type, String livingArea, int age, double wingSpan) {
        super(type, livingArea, age, wingSpan);
    }

    @Override
    public void voice() {
        System.out.println("Csirip csirip");

    }
}
