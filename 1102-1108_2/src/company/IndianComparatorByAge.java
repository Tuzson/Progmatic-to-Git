package org.progmatic.exercises.sandbox;

import org.progmatic.exercises.datastructures.indians.Indian;

import java.util.Comparator;

public class IndianComparatorByAge implements Comparator<Indian> {

    @Override
    public int compare(Indian o1, Indian o2) {
        return o1.getAge() - o2.getAge();
    }
}
