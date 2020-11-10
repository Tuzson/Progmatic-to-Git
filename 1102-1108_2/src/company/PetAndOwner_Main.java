package company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class PetAndOwner_Main {
    public static void main(String[] args) throws FileNotFoundException {

        PetOwnerMerge ownersAndPets = new PetOwnerMerge();
//        System.out.println(ownersAndPets);
//        ownersAndPets.sortByAge();
  //      ownersAndPets.sortByAnimalAgeTree();
        ownersAndPets.listOfOlderAnimalThanTheOwner();

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Írj be egy háziállat nevét");
//        String pet = sc.nextLine();
//        ownersAndPets.whichPetWhichOwner(pet);
//        sc= new Scanner(System.in);
//        System.out.println("Írj be egy állattartó nevét:");
//        String owner = sc.nextLine();
//        ownersAndPets.ownerAnimalsByAge(owner);
        ownersAndPets.theMostAnimalOwner();
        ownersAndPets.theOldestFavoriteAnimal();
        ownersAndPets.nameOfTheYoungestFavoriteAnimal();
        String theMostPopularFirstLetterInAnimalNames = ownersAndPets.getPopularFirstLetter();
        System.out.println("A legnépszerűbb betű amivel a legtöbb állat neve kezdődik: " + theMostPopularFirstLetterInAnimalNames);
        System.out.println(ownersAndPets);
    }
}
