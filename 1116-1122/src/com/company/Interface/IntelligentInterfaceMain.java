package com.company.Interface;

import java.util.Scanner;

public class IntelligentInterfaceMain {

    public static void main(String[] args) {
        LazyTherapist lazyTherapist = new LazyTherapist();
        DullTherapist dullTherapist = new DullTherapist();
        Parrot parrot = new Parrot();
        System.out.println(conversation(parrot));


    }
    public static String conversation(IntelligentInterface text){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String answer =text.communication(s);

        return answer;
    }
}
