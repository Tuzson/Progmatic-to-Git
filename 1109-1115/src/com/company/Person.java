package com.company;

import java.util.ArrayList;

public class Person {

    String name;
    int id;
    Mother mother;
    Dad father;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public Dad getFather() {
        return father;
    }

    public void setFather(Dad father) {
        this.father = father;
    }


    public void idCreator (ArrayList<Person> people){
        int id = 1;
        if (people.size() > 1){
           id = people.size();
           people.get(people.size()-1).setId(id);
            System.out.println(people.get(people.size()-1).getName() + " létrehozva " + people.get(people.size()-1).getId() + "-es azonosítóval. ");
        }
        else {
            people.get(0).setId(id);
            System.out.println(people.get(0).getName() + " létrehozva " + people.get(0).getId() + "-es azonosítóval. ");
        }
    }
}
