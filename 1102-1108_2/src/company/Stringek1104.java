package company;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stringek1104 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Csaba");
        list.add("Cili");
        list.add("Ödön");
        list.add("Cuuu");
        list.add("Olga");

        list.sort(Collator.getInstance());  // Itt az oprendszer nyelve szerinti nyelvcsomagot veszi elő és így lesz pl "cs" meg "ö" betű.
//        System.out.println(list);

        String test = "Ezt most meg fogja számolni 32 :";
        //Írj programot, ami megszámolja, hogy egy string-ben hány betű, hány szám, hány space és hány egyéb karakter van!
        stringCounter(test);
        int a = charCounter(test, 'á');
//        System.out.println(a);
        String alma = "alma";
        String álmatlan = "álmatlan";
        int b = characterCompare(alma, álmatlan);
//        System.out.println(b);
        unicodeValue(1000);
//        System.out.println(unicodeToChar(65));
//        System.out.println(isAlphaNumeric('/'));
        StringBuilder st = new StringBuilder("Fe");
//        System.out.println(ceasar(st, 8, 'E'));
        StringBuilder decode = new StringBuilder(ceasar(st, 8, 'D'));
//        System.out.println(decode);
        HashMap<Character, Character> table = new HashMap<>(replaceTable());
        System.out.println(table);
//        HashMap<Integer,Integer> table2 = new HashMap<>(replaceTable());
        StringBuilder trial = new StringBuilder("Fe");
        StringBuilder encode = new StringBuilder(codingText(trial, table, 'E'));
//      System.out.println(encode);
        StringBuilder decode2 = new StringBuilder(codingText(encode, table, 'D'));
        System.out.println(decode2);


    }

    public static void stringCounter(String s) {
        int nrCounter = 0;
        int charCounter = 0;
        int space = 0;
        int other = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                nrCounter++;
            }
            if (Character.isLetter(c)) {
                charCounter++;
            }
            if (Character.isSpaceChar(c)) {
                space++;
            } else if (Character.isWhitespace(24))
                other++;
        }
        System.out.println("A " + s + " mondatban: " + nrCounter + " db szám, " + charCounter + " db betű " + space + " db szünet " + other + " db egyéb karakter van.");

    }

    public static int charCounter(String s, char x) {
        char[] c = s.toLowerCase().toCharArray();
        int counter = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == x) {
                counter++;
            }
        }
        return counter;
    }

    public static int characterCompare(String a, String b) {
        int length = a.length();
        int counter = 0;
        if (b.length() < length) {
            length = b.length();
        }
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }

    public static void unicodeValue(int length) {
        char c;
        int nr;
        for (int i = 0; i < length + 1; i++) {
            nr = i;
            c = (char) nr;
            System.out.println(i + ": " + c);
        }
    }

    public static char unicodeToChar(int nr) {
        char c;
        c = (char) nr;
        return c;
    }

    public static boolean isAlphaNumeric(char c) {
        Character ch = c;
        return Character.isLetterOrDigit(ch);
    }

    public static StringBuilder ceasar(StringBuilder s, int nr, char c) {
        char a;
        int uni;
        for (int i = 0; i < s.length(); i++) {
            if (c == 'E') {
                uni = s.charAt(i);
                uni += nr;
                a = (char) uni;
                s.setCharAt(i, a);

            } else if (c == 'D') {
                uni = s.charAt(i);
                uni -= nr;
                a = (char) uni;
                s.setCharAt(i, a);

            }
        }
        return s;
    }

    public static HashMap<Character, Character> replaceTable() {
        char c;
        char c2;
        int uni = 0;
        HashMap<Character, Character> hash = new HashMap<>();
        for (int i = 0; i < 128; i++) {
            if (i <= 63) {
                uni = i;
                uni += 2;
                c = (char) i;
                c2 = (char) uni;
                hash.put(c, c2);
            } else {
                uni = i;
                uni -= 2;
                c = (char) i;
                c2 = (char) uni;
                hash.put(c, c2);
            }
        }
        return hash;
    }
//    public static HashMap<Integer, Integer> replaceTableInt() {
//
//        int uni = 0;
//        int uni2 = 0;
//        HashMap<Integer, Integer> hash = new HashMap<>();
//        for (int i = 0; i < 128; i++) {
//            if (i <= 63) {
//                uni = i;
//                uni2 = uni + 2;
//                hash.put(uni, uni2);
//            } else {
//                uni = i;
//                uni2 = uni - 2;
//
//                hash.put(uni, uni2);
//            }
//        }
//        return hash;
//    }


    public static StringBuilder codingText(StringBuilder text, HashMap<Character, Character> table, Character ch) {

        if (ch == 'E') {
            for (int i = 0; i < text.length(); i++) {
                int a = text.charAt(i);
                if (table.containsKey(text.charAt(i))) {
                    text.setCharAt(i, table.get(text.charAt(i)));
                    char c = (char) a;

                } else {
                    System.out.println("Hibás bemenet");
                    return null;
                }
            }
        }
        if (ch == 'D') {

            for (int i = 0; i < text.length(); i++) {
                for (Map.Entry<Character, Character> entry : table.entrySet()) {
                    if (entry.getKey() == (text.charAt(i))) {
                        text.setCharAt(i, table.get(entry.getKey()));
                        break;
                    }
                }
            }


        }
        return text;
    }
////    public static StringBuilder codingText(StringBuilder text, HashMap<Integer, Integer> table, Character ch) {
////
////        if (ch == 'E') {
////            for (int i = 0; i < text.length(); i++) {
////            for (Integer integer : table.keySet()) {
////                    int a =text.charAt(i);
////                    if (integer == a) {
////                        char c = (char) a;
////                        text.setCharAt(i, c);
////                    }
////                }
////            }
////        }
////        if (ch == 'D') {
////            for (int i = 0; i < text.length(); i++) {
////                for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
////                    int a =text.charAt(i);
////                    if (table.containsValue(a)) {
////                        if (entry.getValue() == a) {
////                            a =entry.getKey();
////                            char c = (char)a;
////                            text.setCharAt(i, c);
////                            i++;
////                        }
////                    } else {
////                        System.out.println("Hibás bemenet");
////                        return null;
////                    }
////                }
////            }
////        }
////        return text;
////    }
}