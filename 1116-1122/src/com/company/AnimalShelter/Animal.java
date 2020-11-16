package com.company.AnimalShelter;

public abstract class Animal {
    protected String ownerName;
    protected boolean isHealthy;
    protected int healCost;

    public Animal() {
        int random = (int) (Math.random() * 2);
        isHealthy = random != 0;
    }

    public void heal() {
        isHealthy = true;
    }

    public boolean isAdoptable() {
        return isHealthy;
    }

    @Override
    public String toString() {
        if (!isHealthy) {
            return Animal.class.getName() + " is not healthy. Heal cost: " + healCost + "€ and not adoptable";
        }
        return Animal.class.getName() + " is healthy and adoptable";
    }

    public int getHealCost() {
        return healCost;
    }
}
