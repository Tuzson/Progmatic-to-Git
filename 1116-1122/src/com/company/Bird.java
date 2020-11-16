package com.company;

public abstract class Bird extends Animal {
    double wingSpan;


    public Bird(String type, String livingArea, int age, double wingSpan) {
        super(type, livingArea, age);
        this.wingSpan = wingSpan;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }
}
