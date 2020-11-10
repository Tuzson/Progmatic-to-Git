package com.company;

import java.util.*;

public class hazi_1026 {

    public static void main(String[] args) {

        //Írj programot, ami feltölt egy 1000 méretű Integereket tartalmazó ArrayList-et 1 és 20 közötti véletlen számokkal.
        // A későbbiek során használd ezt a listát!

        List<Integer> list1 = new ArrayList();
        Integer min = Integer.MAX_VALUE;
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            list1.add((int) (Math.random() * 20)+1);
        }

        //Másold át a különböző lista számait egy HashSet-be!
        //Hány különböző szám volt az eredeti listában?
        Set<Integer> set1 = new HashSet(list1);
        System.out.println(set1.size() + " különböző szám volt az eredeti listában.");

        //Keresd meg a Set legkisebb olyan elemét, ami 10-nél nagyobb!

        for (Integer o : set1) {
            if (o > 10 && o < min) {
                min = o;
            }
        }
        System.out.println((min) + (" a legkisebb 10-nél nagyobb elem a set-ben."));

        //Hányszor fordul elő ez az elem az eredeti listában?

        for (Integer o : list1) {
            if (o.equals(min)) {
                counter++;
            }
        }
        System.out.println(counter + " szor fordul elő a " + min + " szám az eredeti ArrayList-ben.");

//A Person osztályt felhasználva hozz létre egy listát 10 személlyel.
// A 10-ben Legyenek olyan személyek, akiknek azonos a nevük (de különböző objektumok legyenek).
        ArrayList<Person> list3 = new ArrayList<>(10);
        list3.add(new Person("Béla",50,102,178));
        list3.add(new Person("Irén",20,87,165));
        list3.add(new Person("Fülöp",44,68,188));
        list3.add(new Person("Béla",51,103,180));
        list3.add( new Person("Fülöp",47,85,184));
        list3.add(new Person("Sára",18,54,162));
        list3.add(new Person("Irén",66,74,173));
        list3.add(new Person("Józsi",37,96,188));
        list3.add(new Person("Béla",80,79,174));
        list3.add(new Person("Károly",61,85,183));

        //Rakd át a listából a Personokat egy HashSet-be. Mekkora lett a Set mérete?

        Set <Person> set2 = new HashSet<>(list3);
        System.out.println(set2.size());

       //Írj metódust, amit törli a Set-ből mindazokat, akik magassága kisebb mint egy megadott érték!

        deleteHeightsWhichLessThan(180,set2);
        System.out.println(set2.size());

        }
        public static Set<Person> deleteHeightsWhichLessThan (int lessThan, Set<Person> set){
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            if (person.getHeight() < lessThan){
                iterator.remove();
                }
            }
            return set;
        }

    }