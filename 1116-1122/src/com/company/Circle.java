package com.company;

public class Circle implements Shape {
    protected double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getCircumstance() {
        return 2 * r * Math.PI;
    }

    @Override
    public double getArea() {
        return r * r * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
