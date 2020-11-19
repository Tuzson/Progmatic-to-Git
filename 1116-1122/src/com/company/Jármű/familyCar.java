package com.company.Jármű;

public class familyCar implements Vehicle {
    protected int maxSpeed;
    protected int weight;
    protected int nrOfSeats;
    protected int bootCapacity;
    protected int age;

    public familyCar(int age) {
        maxSpeed = 150;
        weight = 2000;
        nrOfSeats = 7;
        bootCapacity = 700;
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
        return 30000000/age;
    }
}
