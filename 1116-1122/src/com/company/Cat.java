package com.company;

public class Cat extends Mammal {
   private boolean houseCat;

    public Cat(String type, String livingArea, int age) {
        super(type, livingArea, age);
        int random =(int) (Math.random()*2);
        if (random == 1) {
            houseCat = true;
        }
    }

    @Override
    public void voice() {
        System.out.println("Miau");
    }

    public boolean isHouseCat() {
        return houseCat;
    }

    public void setHouseCat(boolean houseCat) {
        this.houseCat = houseCat;
    }
}
