package com.company;

public class ElectricGuitar extends StringedInstrument {

    public ElectricGuitar() {
        name = "Electric Guitar";
        nrOfStrings = 6;
    }

    public ElectricGuitar(int nrOfStrings) {
        super(nrOfStrings);
        name = "Electric Guitar";
    }

    @Override
    public void sound() {
        System.out.println(name + " a " + nrOfStrings + "-stringed instrument that goes Twang");
    }


    @Override
    public void play() {
    sound();
    }
}
