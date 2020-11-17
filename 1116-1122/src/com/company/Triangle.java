package com.company;

public class Triangle implements Shape {
    protected double a;

    public Triangle(double a) {
        this.a = a;
    }

    @Override
    public double getCircumstance() {
       return  3 * a;
    }

    @Override
    public double getArea() {
        return ((a*a) /4) * Math.sqrt(3);
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
