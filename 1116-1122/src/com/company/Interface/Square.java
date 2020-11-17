package com.company.Interface;

public class Square implements Shape {
    protected double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double getCircumstance() {
        return 4 * a;
    }

    @Override
    public double getArea() {
        return a * a;
    }

    @Override
    public String toString() {
        return "Square";
    }
}
