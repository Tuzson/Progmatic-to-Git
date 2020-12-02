package Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static Set<String> badWords = new HashSet<>();

    public static void main(String[] args) throws BadLanguageException {
 //       System.out.println(string2Date("2011-07-25"));
 //       badWords.add("kurva");
  //      badWords.add("fasz");

       //   numberThinker();
     //    fileReader();
        //   speakNicely("valami, valami akármi");
       ArrayList integers = new ArrayList<>(numbersFromFile("Txt/szavazatok.txt"));
        System.out.println(integers);
        System.out.println(integers.size());
     //   Scanner sc = new Scanner(System.in);
    //    System.out.println(readInt(sc,"SZÁMOT ADJÁL MEG!",null));

    }

    public static LocalDate string2Date(String s) {
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(s);
        } catch (Exception e) {
            System.out.println("Nem jó formátumot adtál meg. A helyes formátum: yyyy-mm-dd ");
        }
        return localDate;
    }

    public static void numberThinker() {
        int random = (int) (Math.random() * 100);
        int nr = 0;
        boolean isNr;
        Scanner sc = new Scanner(System.in);
        System.out.println("Gondoltam egy számra 0 és 100 között. Kitalálod, hogy melyik volt az?");
        do {
            isNr = false;
            while (!isNr) {
                try {
                    isNr = true;
                    nr = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Nem számot írtál be. Kérlek írj be számot.");
                    sc = new Scanner(System.in);
                    isNr = false;
                }
            }
            if (nr > random) {
                System.out.println("A tippelt szám nagyobb mint a gondolt szám. Írj egy másik tippet.");
            } else if (nr < random) {
                System.out.println("A tippelt szám kisebb mint a gondolt szám. Írj egy másik tippet.");
            }

        } while (nr != random);
        System.out.println("Kitaláltad, vége a játéknak");
    }

    public static void fileReader() {
        System.out.println("Írj be egy elérési útvonalat");
        String s;
        Scanner sc = null;
        File f;
        int nr;
        ArrayList<String> arr = new ArrayList<>();
        boolean goToTheNext = false;
        while (!goToTheNext) {
            try {
                sc = new Scanner(System.in);
                s = sc.nextLine();
                f = new File(s);
                sc = new Scanner(f);
                goToTheNext = true;
            } catch (FileNotFoundException e) {
                System.out.println("Nem jó elérési utat adtál meg. Kérlek add meg újra.");
                goToTheNext = false;
            }
        }
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            arr.add(str);
        }
        System.out.println("Írj be, hogy hányadik sort szeretnéd kikérni a beolvasott file-ból:");

        while (goToTheNext) {
            try {
                sc = new Scanner(System.in);
                nr = sc.nextInt();
                goToTheNext = false;
                System.out.println(arr.get(nr - 1));
                sc.close();
            } catch (InputMismatchException e) {
                System.out.println("Nem számot adtál meg. Kérlek adj meg számot");
                goToTheNext = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nincs ilyen sor a file-ban. Kérlek adj meg egy másik számot.");
                goToTheNext = true;
            }
        }
    }

    public static void speakNicely(String s) throws BadLanguageException {

        for (String badWord : badWords) {
            if (s.contains(badWord)) {
                throw new BadLanguageException();
            }
        }
        System.out.println("Nincs csúnya szó a szövegben");
    }

    public static List numbersFromFile(String filePath) {
        File f;
        Scanner sc = null;
        boolean goToTheNext = false;
        List<Integer> integers = new ArrayList<>();
        while (!goToTheNext) {
            try {
                f = new File(filePath);
                sc = new Scanner(f);
                goToTheNext = true;
            } catch (FileNotFoundException e) {
                System.out.println("Nincs ilyen file. Írj be egy új elérési utat.");
                sc = new Scanner(System.in);
                filePath = sc.nextLine();
                goToTheNext = false;
            } catch (InputMismatchException e) {
                System.out.println("Nem jó filenevet adtál meg. Adj meg újat.");
                sc = new Scanner(System.in);
                filePath = sc.nextLine();
                goToTheNext = false;
            }
        }
        while (sc.hasNextLine()) {
            try {
                String str = sc.next();
                integers.add(Integer.valueOf(str));
            } catch (NumberFormatException ignored) {
            }
        }
        sc.close();
        return integers;
    }

    public static int readInt(Scanner sc, String errorMessage, String requestMessage) {
        boolean isNr = false;
        int nr = 0;
        if (errorMessage == null) {
            errorMessage = "Nem számot adtál meg!";
        }
        if (requestMessage == null) {
            requestMessage = "Kérlek adj meg egy számot";
        }
        while (!isNr) {
            try {
                System.out.println(requestMessage);
                nr = sc.nextInt();
                isNr = true;
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                isNr = false;
                sc = new Scanner(System.in);
            }
        }
        sc.close();
        return nr;
    }
}