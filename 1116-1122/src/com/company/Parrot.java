package com.company;

public class Parrot extends Bird {
    public Parrot(String type, String livingArea, int age, double wingSpan) {
        super(type, livingArea, age, wingSpan);
    }

    @Override
    public void voice() {
        System.out.println("Robika vagyok");

    }
}
