package com.company.Zoo2;

public class Zoo2Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.fillUpZoo(50);
        System.out.println(zoo);
        zoo.worker.doDailyRoutine();
        System.out.println(zoo);


    }
}
