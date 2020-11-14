package com.company;

public class HolyFamily {
    public static void main(String[] args) {
        Dad father = new Son();
    }

}
class Logos {

    public Logos() {
        System.out.println("I am the Logos");
    }
}

class Father extends Logos {
    public Father() {
        System.out.println("I am the Father");
    }
}

class Son extends Dad {
    public Son() {
        System.out.println("I am the son");
    }
}

