package com.company;

public abstract class StringedInstrument extends Instrument {
    protected int nrOfStrings;

    public StringedInstrument() {
    }

    public StringedInstrument(int nrOfStrings) {
        this.nrOfStrings = nrOfStrings;
    }

    public abstract void sound();
}
