package com.company;

public class Hoover {
    boolean plugIn;
    boolean turn ;
    boolean  isItFull;

    public Hoover(){
    }
    public  void plugIn(){
        plugIn = true;
    }
    public  void plugOut(){
        plugIn = false;
    }
    public  void turnOn(){
        turn = true;
    }
    public  void turnOff(){
        turn = true;
    }
    public boolean isItFull( ) {
        isItFull = !isItFull;
        return isItFull;
    }

    public boolean isPlugIn() {
        return plugIn;
    }

    public boolean isTurn() {
        return turn;
    }
}
