package com.company.Interface;

public class Hexagon implements Shape {
    protected double a ;

    public Hexagon(double a) {
        this.a = a;
    }

    @Override
    public double getCircumstance() {
        return 6 * a;
    }

    @Override
    public double getArea() {
        return ((3 * Math.sqrt(3))/2) * (a*a);
    }

    @Override
    public String toString() {
        return "Hexagon";
    }
}
