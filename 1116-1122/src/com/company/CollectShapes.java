package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectShapes {

    List<Shape> shapes;

    public CollectShapes() throws FileNotFoundException {
        shapes = readFile();
    }

    public List<Shape> readFile () throws FileNotFoundException {
        List<Shape> shapes = new ArrayList<>();
        Scanner sc = new Scanner(new File("Txt files/shapes.csv"));
        while (sc.hasNext()){
            String[] s = sc.nextLine().split(",");
            if (Integer.parseInt(s[0]) == 0){
                shapes.add(new Circle(Double.parseDouble(s[1])));
            }
            else if ((Integer.parseInt(s[0]) == 3)){
                shapes.add(new Triangle(Double.parseDouble(s[1])));
            }
            else if ((Integer.parseInt(s[0]) == 4)){
                shapes.add(new Square(Double.parseDouble(s[1])));
            }
            else{
                shapes.add(new Hexagon(Double.parseDouble(s[1])));
            }
        }

        return shapes;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

}
