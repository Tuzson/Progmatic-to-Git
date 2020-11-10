package com.company;

import java.util.Comparator;

public class ComparatorBySpeed implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return (int) (o2.getMaxSpeed()-o1.getMaxSpeed());
    }
}
