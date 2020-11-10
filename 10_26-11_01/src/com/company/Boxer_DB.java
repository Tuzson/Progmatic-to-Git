package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Boxer_DB {
//    private ArrayList<Boxer> boxers;
//    private final int[] weightCategories = new int[]{52, 57, 63, 71, 79, 91};
//
//    public Boxer_DB() throws FileNotFoundException {
//        boxers = fillUpBoxers();
//    }
//
//
////    public ArrayList<Boxer> fillUpBoxers() throws FileNotFoundException {
////        Scanner sc = new Scanner(new File("Txt files/boxers.txt"));
////        boxers = new ArrayList<>();
////        for (int i = 0; sc.hasNextLine(); i++) {
////            String[] arr = sc.nextLine().split(",");
////            boxers.add(new Boxer(arr[0], arr[1], Integer.valueOf(arr[2]), Integer.valueOf(arr[3]), Integer.valueOf(arr[4])));
////
////        }
////        return boxers;
////    }
//
////    //Mennyi a magyar boxolók átlagos testsúlya?
////
////    public int averageWeightOfHungarianBoxers() {
////        int average = 0;
////        int counter = 0;
////        for (Boxer boxer : boxers) {
////            if (boxer.getNation().equals("hu")) {
////                counter++;
////                average += boxer.getWeight();
////            }
////        }
////        average = average / counter;
////        return average;
////    }
//
//    //Hány kg-s a legnehezebb boxoló?
//
////    public int theHeaviestBoxer() {
////        int max = 0;
////        for (Boxer boxer : boxers) {
////            if (boxer.getWeight() > max) {
////                max = boxer.getWeight();
////            }
////        }
////        return max;
////    }
//
//
//    public ArrayList<Boxer> getBoxers() {
//        return boxers;
//    }
//
//    public int[] getWeightCategories() {
//        return weightCategories;
//    }
//
//    @Override
//    public String toString() {
//        return "Boxer_DB{" +
//                "boxers=" + boxers +
//                ", weightCategories=" + Arrays.toString(weightCategories) +
//                '}';
//    }
//
//
//    public ArrayList<Boxer> myWeightCategory() {
//
//        for (Boxer boxer : boxers) {
//            if (boxer.getWeight() <= getWeightCategories()[0]) {
//                boxer.setNrOfWeightCategory(0);
//
//            } else if (boxer.getWeight() <= getWeightCategories()[1]) {
//                boxer.setNrOfWeightCategory(1);
//            } else if (boxer.getWeight() <= getWeightCategories()[2]) {
//                boxer.setNrOfWeightCategory(2);
//
//            } else if (boxer.getWeight() <= getWeightCategories()[3]) {
//                boxer.setNrOfWeightCategory(3);
//            } else if (boxer.getWeight() <= getWeightCategories()[4]) {
//                boxer.setNrOfWeightCategory(4);
//            } else if (boxer.getWeight() <= getWeightCategories()[5]) {
//                boxer.setNrOfWeightCategory(5);
//            } else {
//                boxer.setNrOfWeightCategory(6);
//            }
//        }
//        return boxers;
//    }
//
////    //Kik boxolnak az egyes súlycsoportokban?
////
////    public HashMap<Integer, ArrayList<String>> nrOfBoxerPerCategory() {
////        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
////        for (Boxer boxer : boxers) {
////            map.putIfAbsent(boxer.getNrOfWeightCategory(), new ArrayList<>());
////            map.get(boxer.getNrOfWeightCategory()).add(boxer.getName());
////        }
////        return map;
////    }
// //   Van-e olyan boxoló, aki mérkőzés nélkül is nyerni fog (mert egyedül van a  súlycsoportjában)?
//
////    public ArrayList<String> matchWinWithoutFight() {
////        HashMap<Integer, ArrayList<String>> map1 = new HashMap<>(nrOfBoxerPerCategory());
////        ArrayList<String> arr = new ArrayList<>();
////        for (Boxer boxer : boxers) {
////            if (map1.get(boxer.getNrOfWeightCategory()).size() < 2) {
////                arr.add(boxer.getName());
////            }
////        }
////        return arr;
////    }
//    public ArrayList<Integer> hungarianGoldMedal (){
//        HashMap<Integer, ArrayList<String>> map1 = new LinkedHashMap<>(nrOfBoxerPerCategory());
//        HashMap<Integer, ArrayList<String>> map2 = new HashMap<>();
//        ArrayList<Integer> arr = new ArrayList<>();
//        int counter= 0;
//
//
//        for (Boxer boxer : boxers) {
//            if (map1.get(boxer.getNrOfWeightCategory()).equals(boxer.getNation().contains("hu")) && !map1.get(boxer.getNrOfWeightCategory()).contains("en") && !map1.get(boxer.getNrOfWeightCategory()).contains("fr") ){
//                map2.putIfAbsent(boxer.getNrOfWeightCategory(), new ArrayList<>());
//                map2.get(boxer.getNrOfWeightCategory()).add(boxer.getName());
//                if (map1.get(boxer.getNrOfWeightCategory()).contains("hu")){
//                    map2.
//                }
//            }
//        }
//        for (Boxer boxer : boxers) {
//            if (map2.get(boxer.getNrOfWeightCategory()).size() >1){
//                arr.add(boxer.getNrOfWeightCategory());
//            }
//        }
//     return arr;
//    }
}

