package com.company;

public class ElectricBike extends CityBike {
    boolean battery;
    int engine;

    public ElectricBike(double wheelDiameter, int frontCogWheelCogNr, int[] rearCogWheelCogNrs, int engine) {
        super(wheelDiameter, frontCogWheelCogNr, rearCogWheelCogNrs);
        this.engine = engine;
    }

    public void batteryChargeing(){
        battery = true;
    }

    public boolean isBatteryCharged(){
        return battery;
    }

    public int engineHelp(){
        int help = 0;
        if (isBatteryCharged()){
            help = engine * 2;
        }
        return help;
    }
}
