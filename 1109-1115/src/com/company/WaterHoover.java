package com.company;

public class WaterHoover extends Hoover {
    int waterCapacity;

    public WaterHoover() {
    }

    public void fillUpWithWater() {
        waterCapacity = 100;
    }

    public boolean hasWater() {
        if (waterCapacity > 0) {
            return true;
        }
        return false;
    }

    public void clenaingWithWater() {
        if (isPlugIn()) {
            if (isTurn()) {
                if (waterCapacity > 0) {

                    while (waterCapacity > 0) {
                        waterCapacity -= 10;

                    }
                }
                else {
                    System.out.println("Töltsd fel a víztartályt");
                }
            } else {
                System.out.println("Kapcsold be a porszívót");
            }

        } else {
            System.out.println("Dugd be a porszívót");
        }

    }

}