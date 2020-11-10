package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Awards {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Artist> arr1 = new ArrayList<>(fillup());
        TreeSet<String> set = new TreeSet<>(abcSort(arr1));
        System.out.println(set);
        ArrayList<Artist> sortedArtistNames = new ArrayList<>(abcSortComparator(arr1));
        System.out.println(sortedArtistNames);
        HashMap<String, String> artistsByProfession = new HashMap<>(balettArtists(arr1));
        System.out.println(artistsByProfession);
        HashMap<Integer, Integer> theMostAwardedYear = new HashMap<>(theMostAwarded(arr1));
        System.out.println(theMostAwardedYear);
        HashMap<String, Integer> professions = new LinkedHashMap<>(professions(arr1));
        System.out.println(professions);
        HashMap<String, Integer> sameProfessonLikePitti = new HashMap<>(sameProfessionLikePittiKatalin(arr1));
        System.out.println(sameProfessonLikePitti);


    }

    public static ArrayList<Artist> fillup() throws FileNotFoundException {
        ArrayList<Artist> arr = new ArrayList<>();
        Scanner sc = new Scanner(new File("Txt files/szemely.txt"));
        Scanner ss = new Scanner(new File("Txt files/foglalkozas.txt"));
        for (int i = 0; sc.hasNextLine(); i++) {
            String[] people = sc.nextLine().split(",");
            String[] profession = ss.nextLine().split(",");
            HashMap<String, ArrayList<String>> hash = new HashMap<>();
            for (int j = 1; j < profession.length; j++) {
                hash.putIfAbsent(profession[0], new ArrayList<>());
                hash.get(profession[0]).add(profession[j]);
            }
            if (people.length > 2) {
                arr.add(new Artist(people[0], Integer.parseInt(people[1]), people[2], hash.get(profession[0])));

            } else {
                arr.add(new Artist(people[0], Integer.parseInt(people[1]), hash.get(profession[0])));
            }
        }
        return arr;
    }

    public static TreeSet<String> abcSort(ArrayList<Artist> arr1) {
        TreeMap<Integer, ArrayList<String>> tree = new TreeMap<>();
        for (Artist a : arr1) {
            tree.putIfAbsent(a.getAwardYear(), new ArrayList<>());
            tree.get(a.getAwardYear()).add(a.getName());
        }
        TreeSet<String> set = new TreeSet<>(tree.get(2013));
        return set;

    }

    public static ArrayList<Artist> abcSortComparator(ArrayList<Artist> arr1) {

        arr1.sort(new SortByName());

        return arr1;
    }

    public static HashMap<String, String> balettArtists(ArrayList<Artist> arr) {
        String balett = "balett";
        int counter = 0;
        HashMap<String, String> balettArtists = new HashMap<>();
        for (Artist a : arr) {
            for (int i = 0; i < a.getProfessions().size(); i++) {
                if (a.getProfessions().get(i).contains(balett)) {
                    counter = i;
                    balettArtists.putIfAbsent(a.getName(), a.getProfessions().get(counter));
                }
            }
        }
        return balettArtists;
    }

    public static HashMap<Integer, Integer> theMostAwarded(ArrayList<Artist> arr1) {
        HashMap<Integer, ArrayList<String>> awardYears = new HashMap<>();
        HashMap<Integer, Integer> theMostAwardedyear = new HashMap<>();
        int size = 0;
        for (Artist a : arr1) {
            awardYears.putIfAbsent(a.getAwardYear(), new ArrayList<>());
            awardYears.get(a.getAwardYear()).add(a.getName());
        }
        for (Integer integer : awardYears.keySet()) {
            if (awardYears.get(integer).size() > size) {
                size = awardYears.get(integer).size();
                theMostAwardedyear.clear();
                theMostAwardedyear.put(integer, awardYears.get(integer).size());
            }
        }
        return theMostAwardedyear;
    }

    public static HashMap<String, Integer> professions(ArrayList<Artist> art) {
        HashMap<String, ArrayList<String>> hash = new HashMap<>();
        for (Artist artist : art) {
            for (int i = 0; i < artist.getProfessions().size(); i++) {
                hash.putIfAbsent(artist.getProfessions().get(i), new ArrayList<>());
                hash.get(artist.getProfessions().get(i)).add(artist.getName());
            }

        }
        TreeMap<String, Integer> tree = new TreeMap<>();
        for (String s : hash.keySet()) {
            tree.putIfAbsent(s, hash.get(s).size());

        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(tree.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        HashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static HashMap<String, Integer> sameProfessionLikePittiKatalin(ArrayList<Artist> arr) {
        List<String> katalinProfessions = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        for (Artist artist : arr) {
            for (int i = 0; i < artist.getProfessions().size(); i++) {
                if (artist.getName().contains("Pitti Katalin")) {
                    katalinProfessions = (artist.getProfessions());
                    break;
                }
            }
        }
        for (Artist artist1 : arr) {
            for (int i = 0; i < artist1.getProfessions().size(); i++) {
                if (artist1.getProfessions().get(i).contains("katalinProfessions")) {
                    hash.putIfAbsent(artist1.getName(), artist1.getAwardYear());
                }
            }

        }
        return hash;
    }
}
