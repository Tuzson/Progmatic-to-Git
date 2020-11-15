package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree {
    ArrayList<Person> people = new ArrayList<>();

    public ArrayList<Person> familyTreeGenerator() {
        Scanner sc = new Scanner(System.in);
        String name;
        String motherName;
        String fatherName;
        String answer;
        int id;
        boolean retry = true;
        do {
            if (people.size() < 1) {
                System.out.println("Üdvözöllek a családfa generátorban. Írd be a családfa gyökerét:");
                name = sc.nextLine();
                people.add(new Person(name));
                people.get(0).idCreator(people);
                retry = true;
            } else {
                System.out.println("Kinek az anyját és apját adjuk meg? (írd be az azonosítószámát)");
                sc = new Scanner(System.in);
                id = sc.nextInt();
                for (int j = 0; j < people.size(); j++) {
                    if (id == people.get(j).getId()) {
                        System.out.println("Add meg " + people.get(j).getName() + " anyját:");
                        sc = new Scanner(System.in);
                        motherName = sc.nextLine();
                        people.add(new Person(motherName));
                        people.get(people.size() - 1).idCreator(people);
                        Mother mother = new Mother();
                        mother.setName(motherName);
                        people.get(j).setMother(mother);
                        mother.setPerson(people.get(people.size()-1));
                        System.out.println("Add meg " + people.get(j).getName() + " apját:");
                        sc = new Scanner(System.in);
                        fatherName = sc.nextLine();
                        people.add(new Person(fatherName));
                        people.get(people.size() - 1).idCreator(people);
                        Dad father = new Dad();
                        father.setName(fatherName);
                        people.get(j).setFather(father);
                        father.setPerson(people.get(people.size()-1));
                        System.out.println("Szeretél újabb családtagot hozzáadni a családfához? (igen/nem)");
                        sc = new Scanner(System.in);
                        answer = sc.nextLine();
                        if (answer.equals("nem")) {
                            retry = false;
                        }
                    }
                }

            }
        }while (retry);

        return people;
    }

    public void familyTreePrinter(){
        boolean hasParents= true;
        System.out.println(people.get(0).getName());

        for (int i = 0; i < people.size(); i++) {

        }


    }

}
