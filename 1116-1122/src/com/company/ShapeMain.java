package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ShapeMain {

    public static void main(String[] args) throws FileNotFoundException {

        Square square = new Square(6);
        printInfo(square);
        CollectShapes collectShapes = new CollectShapes();
        ArrayList<Shape> shapes = new ArrayList<>(collectShapes.getShapes());
        printInfo(shapes);

        Shape shape = getLargestShape(shapes);
        System.out.println("A legnagyobb területő alakzat : " + shape);

    }

    public static void printInfo(Shape s) {
        System.out.println(s.getCircumstance());
        System.out.println(s.getArea());

        if (s.getArea() < s.getCircumstance()) {
            System.out.println("sovány");
            System.out.println();
        } else if (s.getArea() > s.getCircumstance()) {
            System.out.println("kövér");
            System.out.println();
        } else {
            System.out.println("perfekt");
            System.out.println();
        }
        System.out.println("Arány = " + s.getCircumstance() / s.getArea());
        System.out.println();


    }

    public static void printInfo(List<Shape> list) {

        for (Shape shape : list) {
            System.out.println("Kerület: " + shape.getCircumstance());
            System.out.println("Terület: " + shape.getArea());

            if (shape.getArea() < shape.getCircumstance()) {
                System.out.println(shape + " = sovány");
            } else if (shape.getArea() > shape.getCircumstance()) {
                System.out.println(shape + " = kövér");
            } else {
                System.out.println(shape + " = perfekt");
            }
            System.out.println("Arány = " + shape.getCircumstance() / shape.getArea());
            System.out.println();

        }
    }

    public static Shape getLargestShape(List<Shape> shapes){
        double min = 0;
        Shape shape = null;

        for (Shape value : shapes) {
            if (value.getArea() > min) {
                min = value.getArea();
                shape = value;
            }
        }
       return shape;
    }
}
