package com.company.Zoo2;

import java.util.ArrayList;

public class Worker {
    protected String name;
    protected ArrayList<Animal> animalsToLookAfter;

    public Worker(String name) {
        this.name = name;
        animalsToLookAfter = new ArrayList<>();
    }

    public void doDailyRoutine(){

        for (Animal animal : animalsToLookAfter) {
            if (animal.isHungry()){
                animal.eat();
            }
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                '}';
    }
}
