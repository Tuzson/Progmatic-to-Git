package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class óraifeladat2027_List_Set_Map {
    public static void main(String[] args) throws FileNotFoundException {
        List<Indian> equipments = new LinkedList<>();
        int counter = 0;
        ArrayList<Indian> indianList = new ArrayList<>();
        indianList = fillUp();

        // Hány indián szerepel a leltárban?

        System.out.println(indianList.size());

        //Hány különböző fajta eszköz szerepel a leltárban?


        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < indianList.size(); i++) {
            for (int j = 0; j < indianList.get(i).getEquipments().size(); j++) {
                set2.add(indianList.get(i).getEquipments().get(j));
            }
        }
        System.out.println(set2.size());

        //Hányan vannak egy adott indián törzsben? (A metódus bemeneti paraméterül kapja a törzs nevét.)

        Set<Indian> set1 = new HashSet<>(indianList);
        for (Indian indian : set1) {
            System.out.println("A(z) " + indian.getTribe() + " törzsben " + nrOfTribe(indian.getTribe()) + " indián van");
        }

        //Milyen a férfi arány a Seminole törzsben?

        for (Indian indian : indianList) {
            if (indian.getTribe().equals("Seminole") && indian.getGender().equals("f")) {
                counter++;
            }
        }
        System.out.println("A " + "Seminole törzsben " + nrOfTribe("Seminole") + "/" + counter + " az arány a férfiak és a nők között.");

        //Kik alkotják a vének tanácsát az apache törzsben? (A vének arról ismerszenek meg, hogy van békepipájuk.)

        for (int i = 0; i < indianList.size(); i++) {
            for (int j = 0; j < indianList.get(i).getEquipments().size(); j++) {
                if (indianList.get(i).getTribe().equals("Apache") && indianList.get(i).getEquipments().get(j).equals("békepipa")) {
                    System.out.println(indianList.get(i).getName() + " alkotja a vének tanácsát.");
                }
                if (indianList.get(i).getEquipments().get(j).equals("íj")){
                    equipments.add(indianList.get(i));
                }

            }

        }

        //Átlagosan hány tulajdona van egy indiánnak?

        int sum= 0;
        for (Indian indian : indianList) {
            sum+= indian.getEquipments().size();

        }
        System.out.println("Átlagosan " + sum/indianList.size() + " db tulajdona van egy indiánnak");

        //Hány indiánnak van íja?

        System.out.println(equipments.size() + " indiánnak van íja.");

        //Hány mezítlábas indián van? Mennyi az átlagéletkoruk? (Mezítlábas az, akinek nincs mokaszinje.)

        System.out.println(indiansWithNoShoes(indianList).size() + " mezítlábas indián van");
        int sumAge = 0;
        for (Integer indians : indiansWithNoShoes(indianList)) {
            sumAge += indians;
        }
        System.out.println("A mezítlábas indiánok átlagéletkora: " + sumAge / indiansWithNoShoes(indianList).size());

        HashMap<String,ArrayList<Indian>> indiansByTribe = new HashMap<>();

        for (Indian indian : indianList) {
            indiansByTribe.putIfAbsent(indian.getTribe(),new ArrayList<>());
            indiansByTribe.get(indian.getTribe()).add(indian);
        }
        int max = 0;
        String tribe = null;
        for (Indian indian : set1) {
            if (indiansByTribe.get(indian.getTribe()).size() > max){
                max = indiansByTribe.get(indian.getTribe()).size();
                tribe = indian.getTribe();
            }
        }
        System.out.println("A(z) " + tribe + " törzsben vannak a legtöbben. " + max + " fő");

        //Milyen a férfi arány az egyes indián törzseknél?
        //NEM JÓ!!!

//        int maleIndian = 0;
//        for (Indian indian : set1) {
//            if (indiansByTribe.get(indian.getTribe()).)){
//                maleIndian = indiansByTribe.get(indian.getTribe()).size() - indiansByTribe.get(indian.getTribe()).
//
//            }
//            System.out.println("Az " + indian.getTribe() + " törzs férfi/nő aránya: " + (maleIndian / (indiansByTribe.get(indian.getTribe()).size() - maleIndian)));
//        }

//        for (Indian indian : set1) {
//            if (indiansByTribe.containsKey(indian.getTribe())&& indiansByTribe.get(indian.getTribe().contains(indian.getEquipments().equals("tomahawk"))))
//
//        }

        HashMap<String,ArrayList<Integer>> equipmentsCounter = new HashMap<>();
        counter = 0;
        for (Indian indian : indianList) {
            if (indian.getEquipments().contains("tomahawk")){
                equipmentsCounter.putIfAbsent(indian.getTribe(),new ArrayList<>());
                equipmentsCounter.get(indian.getTribe()).add(indian.getAge());
            }
        }
//        for (Indian indian : set1) {
//
//            System.out.println(equipmentsCounter.get(indian.getTribe()) + " " + equipmentsCounter.get(indian.getTribe()).size());
 //       }


    }

    //Írj programot, ami beolvassa a fájlt és válaszolj az alábbi kérdésekre:

    public static ArrayList<Indian> fillUp() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Txt files/indianok.txt"));
        ArrayList<Indian> list = new ArrayList<>();

        for (int i = 0; sc.hasNext(); i++) {
            String[] arr1 = sc.nextLine().split(",");   //Itt a következő sorban lévő Stringeket szétszedi ott ahol ","-t talál és berakja az arr1 tömbbe.
            String[] arr2 = arr1[4].split("\\|");   //Itt az arr1 tömb 4. indexén található String-et szedi szét ott ahol "|"-t talál és berakja az arr2 tömbbe.
            List<String> set = Arrays.asList(arr2);
            list.add(new Indian(arr1[0], arr1[1], arr1[2], Integer.valueOf(arr1[3]), set));

        }
        return list;
    }

    //Hányan vannak egy adott indián törzsben? (A metódus bemeneti paramforiéterül kapja a törzs nevét.)

    public static int nrOfTribe(String tribe) throws FileNotFoundException {
        ArrayList<Indian> indians = new ArrayList<>(fillUp());
        List<ArrayList<Indian>> sameTribe = new LinkedList<>();
        for (Indian indian : indians) {
            if (indian.getTribe().equals(tribe)) {
                sameTribe.add(indians);
            }

        }
        return sameTribe.size();
    }


    public static ArrayList<Integer> indiansWithNoShoes(ArrayList<Indian> indian){
        ArrayList<Integer> arr = new ArrayList<>();
        for (Indian indian1 : indian) {
            if (indian1.getEquipments().contains("mokaszin")){

            }else {
                arr.add(indian1.getAge());
            }
        }
        return arr;
    }
}