package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class PetOwnerMerge {
    ArrayList<PetOwner> petOwners;
    ArrayList<Pet> pets;

    public PetOwnerMerge() throws FileNotFoundException {
        petOwners = fillupOwners();
        pets = fillUpPets();
        mergePetsWithOwners(petOwners, pets);
        for (int i = 0; i < petOwners.size(); i++) {
            petOwners.get(i).setPetCount(petCounter(i));
            petOwners.get(i).setFavoritePet(petOwners.get(i).getPets().get(0));
        }
        for (int i = 0; i < pets.size(); i++) {
            pets.get(i).setFavorite(amIFavoriteCheck(i));
        }
        for (int i = 0; i < pets.size(); i++) {
            pets.get(i).setOlderThanOwner(isOlderThanOwnerSetter(i));
        }



    }

    public ArrayList<PetOwner> fillupOwners() throws FileNotFoundException {
        ArrayList<PetOwner> petowner = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(new File("Txt files/petowners.txt"));
        for (int i = 0; sc.hasNextLine(); i++) {
            list = new ArrayList<>();
            String[] data = sc.nextLine().split(",");
            for (int j = 3; j < data.length; j++) {
                int a = Integer.parseInt(data[j]);
                list.add(a);
            }
            petowner.add(new PetOwner(data[0], Integer.parseInt(data[1]), data[2], list));
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

    public void mergePetsWithOwners(ArrayList<PetOwner> owners, ArrayList<Pet> pets) {
        for (PetOwner petOwner : owners) {
            for (Pet pet : pets) {
                if (petOwner.getPetId().contains(pet.getId())) {
                    petOwner.setPets(pet);
                    pet.setOwner(petOwner);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "PetOwnerMerge{" +
                "petOwners=" + petOwners +
                ", pets=" + pets +
                '}';
    }

    public void sortByAge() {
        SortByAge comparator = new SortByAge();
        petOwners.sort(comparator);
        System.out.println(petOwners);
    }

//    public void sortByAnimalAge() {
//        SortByAnimalAge comparator = new SortByAnimalAge();
//        pets.sort(comparator);
//        ArrayList<String> petsAge = new ArrayList<>();
//        for (int i = 0; i < pets.size(); i++) {
//            petsAge.add(pets.get(i).getOwner().getName());
//
//        }
//        System.out.println(petsAge);
//        }


    public void sortByAnimalAgeTree() {
        TreeMap<Integer, ArrayList<PetOwner>> tree = new TreeMap<>();
        for (Pet pet : pets) {
            tree.putIfAbsent(pet.getAge(), new ArrayList<>());
            tree.get(pet.getAge()).add(pet.getOwner());
        }
        System.out.println(tree);
    }

    public void listOfOlderAnimalThanTheOwner() {
        ArrayList<PetOwner> owners = new ArrayList<>();
        for (int i = 0; i < petOwners.size(); i++) {
            for (int j = 0; j < petOwners.get(i).getPets().size(); j++) {
                if (petOwners.get(i).getAge() < petOwners.get(i).getPets().get(j).getAge()) {
                    owners.add(petOwners.get(i));
                }
            }
        }
        System.out.println(owners);
    }

    public void whichPetWhichOwner(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < petOwners.size(); i++) {
            for (int j = 0; j < petOwners.get(i).getPets().size(); j++) {
                if (petOwners.get(i).getPets().get(j).getName().equals(s)) {
                    System.out.println(petOwners.get(i).getPets().get(j).getName() + " gazdája: " + petOwners.get(i).getName());
                    break;
                }
            }
        }
    }

    public void ownerAnimalsByAge(String s) {
        ArrayList<ArrayList<Pet>> arr = new ArrayList<>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getOwner().getName().equals(s)) {
                SortByAnimalAge comparator = new SortByAnimalAge();
                arr.add(petOwners.get(i).getPets());
                arr.sort(comparator);
                break;

            }
        }
        System.out.println(arr);
    }

    public void theMostAnimalOwner() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < petOwners.size(); i++) {
            if (petOwners.get(i).getPets().size() > max) {
                max = petOwners.get(i).getPets().size();
                index = i;
            }
        }
        System.out.println("A legtöbb állata: " + petOwners.get(index).getName() + "-nak van. Összesen: " + max + " állat.");
    }

    public int petCounter(int nr) {
        return petOwners.get(nr).getPets().size();

    }

    public boolean amIFavoriteCheck(int nr){
            if (pets.get(nr).getName().equals(pets.get(nr).getOwner().getFavoritePet().getName())){
                return true;

        }
        return false;
    }

    public void theOldestFavoriteAnimal() {
        int age = 0;
        int index = 0;
        for (int i = 0; i < petOwners.size(); i++) {
            if (petOwners.get(i).getFavoritePet().getAge() > age) {
                age = petOwners.get(i).getFavoritePet().getAge();
                index = i;
            }
        }
        System.out.println(petOwners.get(index).getName() + "-nek van a legidősebb háziállata. " + petOwners.get(index).getFavoritePet());

    }

    public void nameOfTheYoungestFavoriteAnimal() {
        int min = 1000;
        int index = 0;
        for (int i = 0; i < petOwners.size(); i++) {
            if (petOwners.get(i).getFavoritePet().getAge() < min) {
                min = petOwners.get(i).getFavoritePet().getAge();
                index = i;
            }
        }
        System.out.println("A legfialabb kedvenc háziállat: " + petOwners.get(index).getFavoritePet() + "\nGazdája: " + petOwners.get(index).getName());
    }

    public String getPopularFirstLetter() {
        ArrayList<String> animalNames = new ArrayList<>();
        SortAnimalByName comparator = new SortAnimalByName();
        String c = null;
        int counter = 1;
        int max = 0;

        pets.sort(comparator);
        for (int i = 0; i < pets.size(); i++) {
            animalNames.add(pets.get(i).getName());
        }
        for (int i = 0; i < animalNames.size() - 1; i++) {
            if (animalNames.get(i).charAt(0) == animalNames.get(i + 1).charAt(0)) {
                counter++;
                if (counter > max) {
                    max = counter;
                    c = Character.toString(animalNames.get(i).charAt(0));
            }

            }
            else {
                counter= 1;
            }

        }
        return c;
    }

    public boolean isOlderThanOwnerSetter(int nr){
        return pets.get(nr).getAge() > pets.get(nr).getOwner().getAge();
    }

}