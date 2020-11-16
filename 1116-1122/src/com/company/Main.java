package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//    Point3D point3D = new Point3D(4,3,6);
//    point3D.origoX2();
//        System.out.println(point3D);

        Zoo zoo = new Zoo();
        ArrayList<Animal> animals = new ArrayList<>(zoo.fillUpZoo(30));
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).voice();
        }
        nrOfSpec(animals);

        rateOfCats(animals);

        averageOfBirdWingSpan(animals);

        playWithTheDogs(animals);



    }

    public static void nrOfSpec(ArrayList<Animal> animals){
        int nrOfMammal = 0;
        int nrOfBird = 0;

        for (Animal animal : animals){
            if (animal instanceof Mammal){
                nrOfMammal++;
            }
            else {
                nrOfBird++;
            }
        }
        System.out.println("Emlős: " + nrOfMammal);
        System.out.println("Madár: " + nrOfBird);
    }

    public static void rateOfCats(ArrayList<Animal> animals){
        int nrOfHouseCat = 0;
        int nrOfWildCat = 0;
        double result = 0;

        for (Animal animal : animals) {
            if (animal instanceof Cat){
                if (((Cat) animal).isHouseCat()){
                    nrOfHouseCat++;
                }
                else {
                    nrOfWildCat++;
                }
            }
        }

        result = ((double) nrOfHouseCat / (nrOfHouseCat+nrOfWildCat)) *100;

        System.out.println("A macskák közül " + result + "% házimacska");
    }

    public static void averageOfBirdWingSpan(ArrayList<Animal> animals){
        double sumWingSpan = 0;
        int nrOfBird = 0;
        double result = 0;

        for (Animal animal : animals) {
            if (animal instanceof Bird){
                sumWingSpan+= ((Bird) animal).getWingSpan();
                nrOfBird++;
            }
        }
        result = sumWingSpan / nrOfBird;
        System.out.println("A madarak átlagos fesztávja: " + result + " cm");
    }

    public static void playWithTheDogs(ArrayList<Animal> animals){
        for (Animal animal : animals) {
            if (animal instanceof Dog){
                ((Dog) animal).play();
            }
        }
    }
}