package com.company.Jármű;

public class Van implements Vehicle{
    protected int maxSpeed;
    protected int weight;
    protected int nrOfSeats;
    protected int bootCapacity;
    protected int age;

    public Van(int age) {
        maxSpeed = 130;
        weight = 2300;
        nrOfSeats = 3;
        bootCapacity = 4000;
        this.age = age;
    }


    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int nrOfSeats() {
        return nrOfSeats;
    }

    @Override
    public int capacityOfBoot() {
        return bootCapacity;
    }

    @Override
    public int price(int age) {
        return 15000000 / age;
    }
}
