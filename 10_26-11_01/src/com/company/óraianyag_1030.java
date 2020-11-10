package com.company;

import java.util.*;

public class óraianyag_1030 {
    public static void main(String[] args) {
        Map<Integer, String> ize = new HashMap<>();
        ize.put(1, "alma");
        ize.put(2, "barack");
        ize.put(3, "citrom");

        for (Integer i : ize.keySet()) {
            System.out.println(i + ": " + ize.get(i));
        }
        for (String value : ize.values()) {
            System.out.println(value);
        }
        Set<Map.Entry<Integer, String>> entries = ize.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {

        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);

        ArrayList<Integer> arr2 = new ArrayList<>(numbersReverse(arr));
        System.out.println(arr2);


        Queue q = new Queue();
        q.add(1,45217);
        q.add(1,4552);
        q.add(1,7312547);
        q.add(2,52378963);
        System.out.println(q);


        Integer number=3654;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (number > 0) {
            stack.push( number % 10 );
            number = number / 10;
        }

//        while (!stack.isEmpty()) {
//            System.out.println((stack.pop()));
//
//            }
        String nr = String.valueOf(number);
       char[] test =  nr.toCharArray();
        System.out.println(test);
    }



    public static ArrayList<Integer> numbersReverse(ArrayList<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            stack.push(arr.get(i));
        }
        for (int i = 0; i < arr.size(); i++) {
            arr2.add(stack.pop());

        }

        return arr2;
    }

}