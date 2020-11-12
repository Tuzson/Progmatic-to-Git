package com.company;

public class GeekBike extends BikeÖröklődés{

    public GeekBike(double wheelDiameter, int frontCogWheelCogNr, int[] rearCogWheelCogNrs) {
        super(wheelDiameter, frontCogWheelCogNr, rearCogWheelCogNrs);
    }

   public void timeTogetToComputerStore(double cadence, int gearPos, double distanceOfComputerStore){
        GeekBike bike = new GeekBike(28,30,new int[]{12,14,16,18,20,22});
        bike.setGear(gearPos);
        double timeToArrive = 0;
        timeToArrive = bike.getSpeed(cadence) / distanceOfComputerStore;
       System.out.println(timeToArrive + "óra múlva érünk oda a boltba");
   }
}
