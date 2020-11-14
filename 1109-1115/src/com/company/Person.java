package com.company;

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
}
