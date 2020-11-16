package com.company.AnimalShelter;

public class Main {

    public static void main(String[] args) {

        AnimalShelter animalShelter = new AnimalShelter();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Parrot parrot = new Parrot();

        animalShelter.rescue(cat);
        animalShelter.rescue(dog);
        animalShelter.rescue(parrot);
animalShelter.findNewOwner();
animalShelter.heal();

        System.out.println(cat);


        System.out.println(animalShelter);
            System.out.println(animalShelter.getAnimals());

    }
}
