package com.company;

public class Main {

    public static void main(String[] args) {
        CityBike cityBike = new CityBike(28,30,new int[]{12,14,16,18,20,22});
        cityBike.isLighting();
        cityBike.switchLight();
        cityBike.isLighting();
        cityBike.horning();

    }
}
