package com.company;

public class CityBike extends BikeÖröklődés {
  protected   boolean light;
   protected String horn;

    public CityBike(double wheelDiameter, int frontCogWheelCogNr, int[] rearCogWheelCogNrs) {
        super(wheelDiameter, frontCogWheelCogNr, rearCogWheelCogNrs);
    }

    public void switchLight (){
        light= !light;
    }
    public void isLighting (){
        System.out.println(light);
    }
    public void horning(){
        horn = "Csing csing";
        System.out.println(horn);
    }



}
