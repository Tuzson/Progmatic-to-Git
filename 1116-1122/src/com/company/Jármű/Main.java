package com.company.Jármű;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        SportCar sportCar = new SportCar(2);
        familyCar familyCar = new familyCar(21);
        Van van = new Van(1);
        main.getTargetCustomer(sportCar, sportCar.getAge());
    }

    public void getTargetCustomer(Vehicle vh, int age) {

        if (vh.getMaxSpeed() == 300) {
            System.out.println("Autóversenyzőknek és szingliknek ajánlott. Ára: " + vh.price(age));
        } else if (vh.getMaxSpeed() == 150) {
            System.out.println("Családoknak ajánlott. Ára: " + vh.price(age));
        } else if (vh.getMaxSpeed() == 130) {
            System.out.println("Cégeknek és kamionosoknak ajánlott. Ára: " + vh.price(age));
        }
    }
}