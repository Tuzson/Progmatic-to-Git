package com.company.Zoo2;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String gender;
    protected int fedTimes;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        fedTimes = 0;
    }

    public void eat(){
        fedTimes++;
    }

    public abstract boolean isHungry();


    public String toString(){
        return name + " is a " + age + " years old " + gender + " animal and was fed " + fedTimes + " times \n";
    }

}
