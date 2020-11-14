package com.company;

public class Dad {
    Person son;
    int id;
    Mother mother;
    Dad father;

    public Person getSon() {
        return son;
    }

    public void setSon(Person son) {
        this.son = son;
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
