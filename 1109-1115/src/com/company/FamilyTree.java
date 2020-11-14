package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree {
    ArrayList<Person> people;

    public void familyTreeGenerator(){
        Scanner sc = new Scanner(System.in);
        String name;
        String motherName;
        String fatherName;
        int id;
        boolean retry;
        int i;
        do {
            System.out.println("Üdvözöllek a családfa generátorban. Írd be a családfa gyökerét:");
            name = sc.nextLine();
            people.add(new Person(name));
            people.get(0).setId(1);
            retry = true;
        }
        while (retry);
        i= people.size()-1;
        System.out.println(people.get(i).getName() + "létrehozva " + people.get(i).getId() + "-es azonosítóval. " + "Kinek az anyját és apját adjuk meg?");
        sc = new Scanner(System.in);
        id = sc.nextInt();
        for (int j = 0; j < people.size(); j++) {
            if (id == people.get(j).getId()){
                System.out.println("Add meg" + people.get(i).getName() + " anyját:");
                sc = new Scanner(System.in);
                motherName = sc.nextLine();
                System.out.println();

        }



        }

    }
}
