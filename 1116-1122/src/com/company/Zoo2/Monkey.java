package com.company.Zoo2;

public class Monkey extends Animal {

    public Monkey(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public boolean isHungry() {
       int random =(int) (Math.random()*2);
        return random != 0;
    }
}
