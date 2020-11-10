package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Eszemiszom {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Election> people = new ArrayList<>(fillup());
        System.out.println("A helyhatósági választáson " + people.size() + " képviselőjelölt indult.");

        String name = "Bab Zsuzsanna";
        if (nrOfVotes(people,name)> -1){
            System.out.println(name + "-nak " + nrOfVotes(people,name) + " szavazata van.");
        }
        else {
            System.out.println("Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!");
        }

    }
    public static ArrayList<Election> fillup () throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Txt files/szavazatok.txt"));
        ArrayList<Election> people = new ArrayList<>();
        for (int i = 0;sc.hasNextLine(); i++) {
            String district = sc.next();
            String votes = sc.next();
            String Surname = sc.next();
            String FirstName = sc.next();
            String fullName = Surname.concat(" ").concat(FirstName);
            String support = sc.next();
            people.add(new Election(Integer.parseInt(district),Integer.parseInt(votes),fullName,support));


        }
        return people;
    }

    public static int nrOfVotes (ArrayList<Election>arr,String name){
        for (Election election : arr) {
            if (election.getName().contains(name)){

                return election.getVotes();
            }
        }
        return -1;
    }

}
