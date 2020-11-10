package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>(4);
        Person ferenc = new Person("Ferenc", 41, 80, 177);
        Person gyula = new Person("Gyula", 27, 67, 182);
        Person noémi = new Person("Noémi", 33, 50, 164);
        Person fanni = new Person("Fanni", 50, 61, 170);

        List<Integer> list2 = new ArrayList<>() {
        };
        for (int i = 0; i < 10; i++) {
            Integer random = (int) (Math.random() * 100);
            list2.add(random);
        }

        System.out.println("For i ciklus: " + deleteEvenNums(list2));
        System.out.println(deleteEvenNumsForEach(list2));
        System.out.println("While esetén: " + deleteEvenNumsWhile(list2));

//        list.add(ferenc);
//        list.add(gyula);
//        list.add(noémi);
//        list.add(fanni);
//
//
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).setAge((int) (Math.random()*80));
//            list.get(i).setHeight((int)(Math.random()*200)+145);
//            list.get(i).setWeight((int) (Math.random() * 200)+40);
//        }
//
//        System.out.println("Legkisebb súly: " + minimumWeight(list) + " kg");
//        System.out.println("Magasság összesen: " + sumHeight(list) + " cm");
//        System.out.println( "Átlag életkor: " + averageOfAge(list) + " év");
//

    }

    public static int minimumWeight(ArrayList<Person> list1) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getWeight() < min) {
                min = list1.get(i).getWeight();
            }

        }
        return min;
    }

    public static int sumHeight(ArrayList<Person> list1) {
        int sum = 0;
        for (int i = 0; i < list1.size(); i++) {
            sum += list1.get(i).getHeight();

        }
        return sum;
    }

    public static int averageOfAge(ArrayList<Person> list1) {
        int avarage = 0;

        for (int i = 0; i < list1.size(); i++) {
            avarage += list1.get(i).getAge();
        }
        return avarage / list1.size();
    }

    public static List<Integer> deleteEvenNums(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0) {
                nums.remove(nums.get(i));
            }

        }
        return nums;
    }

    public static List<Integer> deleteEvenNumsForEach(List<Integer> nums) {
        for (Integer number : nums) {
            if (number % 2 == 0) {
                nums.remove(number);
            }

        }
        return nums;
    }

    public static List<Integer> deleteEvenNumsWhile(List<Integer> nums) {
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            Integer nr = iterator.next();
            if (nr % 2 == 0) {
                iterator.remove();
            }
        }
        return nums;
    }
}
