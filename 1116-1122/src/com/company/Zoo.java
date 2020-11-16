package com.company;

import java.util.ArrayList;

public class Zoo {

    ArrayList<Animal> animals = new ArrayList<>();

    public Zoo() {
    }

    public ArrayList<Animal> fillUpZoo(int nrOfAnimal){

        for (int i = 0; i < nrOfAnimal; i++) {
            int random =(int) ((Math.random()*4)+1);
            int age = (int)(Math.random()*10+1);
            int wingSpan = (int)(Math.random()*50+10);
            switch (random) {
                case 1 -> {
                    Dog dog = new Dog("Dog", "house", age);
                    animals.add(dog);
                }
                case 2 -> {
                   Cat cat = new Cat("Cat", "house", age);
                    if (!cat.isHouseCat()) {
                        cat.setLivingArea("wild");
                    }
                    animals.add(cat);
                }
                case 3 -> {
                    Parrot parrot = new Parrot("Parrot", "wild", age, wingSpan);
                    animals.add(parrot);
                }
                case 4 -> {
                    Canari canari = new Canari("Canari", "wild", age, wingSpan);
                    animals.add(canari);
                }
            }
        }

        return animals;
    }

}
