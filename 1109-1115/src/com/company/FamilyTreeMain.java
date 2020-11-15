package com.company;

import java.util.ArrayList;

public class FamilyTreeMain {

    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();
        ArrayList<Person> people = new ArrayList<>(familyTree.familyTreeGenerator());
        System.out.println(people);
    }
}
