package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cleaning {
    public static void main(String[] args) throws InterruptedException {
        String answer = "";
        int speed;
        int dustLevel;
        Hoover dyson = new Hoover();
        System.out.println("Köszönöm, hogy megvásároltad a Dyson legújabb fejlesztésű inteligens autómata porszívóját.\n" +
                "Kérlek válaszolj az alábbi kérdésekre:\n" +
                "");
        System.out.println("Milyen gyorsan porszivózzak? (1-5)");
        Scanner sc = new Scanner(System.in);
        speed = sc.nextInt();
        System.out.println("Milyen poros a lakás? (1-5)");
        dustLevel = sc.nextInt();
        System.out.println("FIGYELEM! " + (100 - ((speed + dustLevel - 1) * 10)) + " perc múlva telítődik meg a porzsák! ");
        System.out.println();
        System.out.println(" Porszívózás..." + (100 - ((speed + dustLevel - 1) * 10)) + " percen keresztül");
        TimeUnit.SECONDS.sleep(dustLevel * 3 - speed);
        dyson.isItFull();
        while (dyson.isItFull) {
            System.out.println("A porzsák megtelt!!");
            System.out.println("Kapcsold ki a porszívót. (turn off)");
            sc = new Scanner(System.in);
            answer = sc.nextLine();
            if (answer.equals("turn off")) {
                dyson.turnOff();
            }else{
                    System.out.println("Mondom kapcsold ki!!!!!!!!!");
                    answer = sc.nextLine();
                }
            System.out.println("Nagyon jó. Most pedig húzd ki.(plug out)");
            answer=sc.nextLine();
            if (answer.equals("plug out")) {
                dyson.plugOut();
            }
            else {
                System.out.println("Meddig várjak még?????");
                answer = sc.nextLine();
            }
            System.out.println("Szóhoz se jutok. Végül cseréld ki a porzsákot.Ok ha megvan.");
            Scanner ss = new Scanner(System.in);
            answer = ss.nextLine();
            if (!dyson.turn && !dyson.plugIn && answer.equals("Ok")) {
                dyson.isItFull();
            }
            else {
                System.out.println("Cseréld már ki az isten szerelmére!");
                answer = ss.nextLine();
                dyson.isItFull();
            }
        }
            System.out.println("Úgy látom, hogy különösen ügyetlen vagy a háztartási gépek használatában, ezért elvégzem automatikusan a következő folymatokat: \n ");

            dyson.plugIn();
        System.out.println("Áramkörre való csatlakozás...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Csatlakoztatva");
            dyson.turnOn();
        System.out.println("Bekapcsolás...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Bekapcsolva");
        TimeUnit.SECONDS.sleep(3);
            System.out.println("Porszívózás...");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Tiszta a lakás. Kapcsold ki majd húzd ki a dúgót. Űritsd ki a porzsákot és igyál egy hatalmas sört!");
    }
}