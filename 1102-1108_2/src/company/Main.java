package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    ArrayList<Animal> animal1 = new ArrayList<>(fillup());
    ArrayList<Animal2> animal2 = new ArrayList<>(fillup2());
    animal1 = animalFull(animal1,animal2);
        System.out.println(animal1);
        animal1.sort(new ComparatorBySpeed());
        System.out.println(animal1.get(0) + " " + animal1.get(1) + " " + animal1.get(2));
    }
    public static ArrayList<Animal> fillup() throws FileNotFoundException {
        ArrayList<Animal> arr = new ArrayList<>();
        Scanner sc = new Scanner(new File("Txt files/animals.txt"));
        for (int i = 0; sc.hasNextLine(); i++) {
        String[]animals =sc.nextLine().split(",");
                arr.add(new Animal(animals[0],animals[1],Double.parseDouble(animals[2]),Double.parseDouble(animals[3]),Double.parseDouble(animals[4])));
        }
        return arr;
    }
    public static ArrayList<Animal2> fillup2 () throws FileNotFoundException {
        ArrayList<Animal2> arr2 = new ArrayList<>();
        Scanner ss = new Scanner(new File("Txt files/foldresz.txt"));
        HashMap<String, ArrayList<String>> hash = new HashMap<>();
        for (int i = 0; ss.hasNextLine(); i++) {
            String[] country = ss.nextLine().split(",");
            for (int j = 1; j < country.length; j++) {
                hash.putIfAbsent(country[0], new ArrayList<>());
                hash.get(country[0]).add(country[j]);
            }
            arr2.add(new Animal2(country[0], hash.get(country[0])));
        }
        return arr2;
    }
    public static ArrayList<Animal> animalFull (ArrayList<Animal> animal1,ArrayList<Animal2> animal2){
        for (Animal animal : animal1) {
            for (Animal2 value : animal2) {
                if (animal.getSpecies().equals(value.getSpecies())) {
                    animal.setLifeArea(value.getLifeArea());
                }
            }

        }
        return animal1;

    }

}