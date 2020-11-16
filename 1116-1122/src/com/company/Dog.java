package com.company;

public class Dog extends Mammal {

    public Dog(String type, String livingArea, int age) {
        super(type, livingArea, age);
    }

    @Override
    public void voice() {
        System.out.println("Vau vau");
    }

    public void play(){
        System.out.println("Play");
    }



}
