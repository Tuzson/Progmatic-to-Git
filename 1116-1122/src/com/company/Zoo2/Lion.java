package com.company.Zoo2;

public class Lion extends Animal {

    public Lion(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public boolean isHungry() {
        return true;
    }

}