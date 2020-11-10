package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PetOwnerMerge {
    ArrayList<PetOwner> petOwners;
    ArrayList<Pet> pets;

    public PetOwnerMerge() throws FileNotFoundException {
        petOwners = new ArrayList<>(fillupOwners());
        pets = new ArrayList<>(fillUpPets());
//        mergePetsWithOwners(petOwners,pets);

    }

    public ArrayList<PetOwner> fillupOwners() throws FileNotFoundException {
        ArrayList<PetOwner> petowner = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(new File("Txt files/petowners.txt"));
        for (int i = 0; sc.hasNextLine(); i++) {
            String[] data = sc.nextLine().split(",");
            for (int j = 3; j < data.length; j++) {
                int a = Integer.parseInt(data[j]);
                list.add(a);
            }
            petowner.add(new PetOwner(data[0], Integer.parseInt(data[1]), data[2],list));
            System.out.println(petowner);
            list = new ArrayList<>();

        }
        return petowner;
    }

    public ArrayList<Pet> fillUpPets() throws FileNotFoundException {
        ArrayList<Pet> pets = new ArrayList<>();
        Scanner sc = new Scanner(new File("Txt files/pets.txt"));
        for (int i = 0; sc.hasNextLine(); i++) {
            String[] data = sc.nextLine().split(",");
            pets.add(new Pet(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3])));

        }

        return pets;
    }

//    public void mergePetsWithOwners(ArrayList<PetOwner> owners, ArrayList<Pet> pets) {
//
//        for (PetOwner petOwner : owners) {
//            for (Pet pet : pets) {
//                if (petOwner.getPetId().contains(pet.getId())) {
//                    petOwner.setPets(pet);
//                    pet.setOwner(petOwner);
////                    System.out.println(petOwner.getName());
////                    System.out.println(pet.getAge());
//                }
//            }
//        }
//    }
}