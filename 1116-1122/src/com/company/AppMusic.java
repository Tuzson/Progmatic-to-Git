package com.company;

public class AppMusic {

    public static void main(String[] args) {

        ElectricGuitar guitar = new ElectricGuitar();
        BassGuitar bassGuitar = new BassGuitar();
        Violin violin = new Violin();
        guitar.play();
        bassGuitar.play();
        violin.play();

        ElectricGuitar guitar2 = new ElectricGuitar(7);
        BassGuitar bassGuitar2 = new BassGuitar(5);
        guitar2.play();
        bassGuitar2.play();

    }
}
