package com.company.Jármű;

public class SportCar implements Vehicle {
    protected int maxSpeed;
    protected int weight;
    protected int nrOfSeats;
    protected int bootCapacity;
    protected int age;

    public SportCar(int age) {
        maxSpeed = 300;
        weight = 1500;
        nrOfSeats = 2;
        bootCapacity = 150;
        this.age = age;
    }

    public int getAge() {
        return age;
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
        return 50000000 /age;
    }
}
