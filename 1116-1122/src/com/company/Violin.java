package com.company;

public class Violin extends StringedInstrument {

    public Violin() {
        name = "Violin";
        nrOfStrings = 4;
    }

    public Violin(int nrOfStrings) {
        super(nrOfStrings);
        name = "Violin";
    }

    @Override
    public void sound() {
        System.out.println(name + " a " + nrOfStrings + "-stringed instrument that goes Screech");
    }


    @Override
    public void play() {
        sound();
    }
}
