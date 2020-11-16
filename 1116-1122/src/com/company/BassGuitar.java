package com.company;

public class BassGuitar extends StringedInstrument {

    public BassGuitar() {
        name = "Bass Guitar";
        nrOfStrings = 4;
    }

    public BassGuitar(int nrOfStrings) {
        super(nrOfStrings);
        name = "Bass Guitar";
    }

    @Override
    public void sound() {
        System.out.println(name + " a " + nrOfStrings + "-stringed instrument that goes Duuum-duum-duum");
    }

    @Override
    public void play() {
        sound();
    }
}
