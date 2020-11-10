package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BoxMatch {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Boxer> boxers = new ArrayList<>(fillUpWithBoxers());

        System.out.println(averageWeightOfHungarianBoxers(boxers));
        System.out.println(theHeaviestBoxer(boxers));
        System.out.println(nrOfBoxerPerCategoryByNation(boxers));
        System.out.println(matchWinWithoutFight(boxers) + " egyedül van a súlycsoportjában");
        System.out.println("A súlycsoport ahol biztos a magyar aranyérem: " + hungarianGoldMedal(boxers));
        heavyWeightMatches(boxers);


    }

    public static ArrayList<Boxer> fillUpWithBoxers() throws FileNotFoundException {
        ArrayList<Boxer> boxers = new ArrayList<>();
        Scanner sc = new Scanner(new File("Txt files/boxers.txt"));
        for (int i = 0; sc.hasNextLine(); i++) {
            String[] arr = sc.nextLine().split(",");
            boxers.add(new Boxer(arr[0], arr[1], Integer.valueOf(arr[2]), Integer.valueOf(arr[3]), Integer.valueOf(arr[4])));
        }
        return boxers;
    }
    //Mennyi a magyar boxolók átlagos testsúlya?

    public static int averageWeightOfHungarianBoxers(ArrayList<Boxer> boxers) {
        int average = 0;
        int counter = 0;
        for (Boxer boxer : boxers) {
            if (boxer.getNation().equals("hu")) {
                counter++;
                average += boxer.getWeight();
            }
        }
        average = average / counter;
        return average;
    }

    public static int theHeaviestBoxer(ArrayList<Boxer> boxers) {
        int max = 0;
        for (Boxer boxer : boxers) {
            if (boxer.getWeight() > max) {
                max = boxer.getWeight();
            }
        }
        return max;
    }
    //Kik boxolnak az egyes súlycsoportokban?

    public static HashMap<Integer, ArrayList<String>> nrOfBoxerPerCategoryByNation(ArrayList<Boxer> boxers) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (Boxer boxer : boxers) {
            map.putIfAbsent(boxer.getNrOfWeightCategory(), new ArrayList<>());
            map.get(boxer.getNrOfWeightCategory()).add(boxer.getNation());
        }
        return map;
    }

    public static HashMap<Integer, ArrayList<String>> nrOfBoxerPerCategoryByName(ArrayList<Boxer> boxers) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (Boxer boxer : boxers) {
            map.putIfAbsent(boxer.getNrOfWeightCategory(), new ArrayList<>());
            map.get(boxer.getNrOfWeightCategory()).add(boxer.getName());
        }
        return map;
    }


    public static ArrayList<String> matchWinWithoutFight(ArrayList<Boxer> boxers) {
        HashMap<Integer, ArrayList<String>> map1 = new HashMap<>(nrOfBoxerPerCategoryByNation(boxers));
        ArrayList<String> arr = new ArrayList<>();
        for (Boxer boxer : boxers) {
            if (map1.get(boxer.getNrOfWeightCategory()).size() < 2) {
                arr.add(boxer.getName());
            }
        }
        return arr;
    }

    public static ArrayList<Integer> hungarianGoldMedal(ArrayList<Boxer> boxers) {
        HashMap<Integer, ArrayList<String>> map1 = new HashMap<>(nrOfBoxerPerCategoryByNation(boxers));
        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer i : map1.keySet()) {
            if (map1.get(i).contains("hu") && !map1.get(i).contains("en") && !map1.get(i).contains("fr")) {
                arr.add(i);

            }

        }
        return arr;
    }

    public static void englishBoxersWithSameWeight(ArrayList<Boxer> boxers) {
        int counter = 0;
        TreeMap<String, ArrayList<Integer>> map1 = new TreeMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (Boxer boxer : boxers) {
            map1.putIfAbsent(boxer.getNation(), new ArrayList<>());
            map1.get(boxer.getNation()).add(boxer.getWeight());
        }
        for (int i = 0; i < map1.get("en").size(); i++) {
            for (int j = i + 1; j < map1.get("en").size(); j++) {
                if (map1.get("en").get(i).equals(map1.get("en").get(j))) {
                    counter++;
                    System.out.println("Azonos súly: " + map1.get("en").get(i));
                }
            }
        }
        System.out.println("Összesen " + counter * 2 + " db angol boxoló van azonos súllyal");
    }

    public static void heavyWeightMatches(ArrayList<Boxer> boxers) {
        TreeMap<Integer, ArrayList<String>> heavyWeight = new TreeMap<>(nrOfBoxerPerCategoryByName(boxers));
        for (Integer i : heavyWeight.keySet()) {
            for (int j = 0; j < heavyWeight.get(i).size()-1; j++) {
                if (i == 4) {
                    System.out.println(heavyWeight.get(i).get(j) + " vs " + heavyWeight.get(i).get(j + 1));
                }
            }
        }
    }
}
