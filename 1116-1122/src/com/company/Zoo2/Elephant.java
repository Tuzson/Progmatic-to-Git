package com.company.Zoo2;

public class Elephant extends Animal {

    public Elephant(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public boolean isHungry() {
        return true;
    }
}
