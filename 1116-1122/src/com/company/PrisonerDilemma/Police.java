package com.company.PrisonerDilemma;

import com.company.Main;

import java.util.*;

public class Police {
    List<Suspect> suspects;
    Map<Suspect, Integer> statistics;

    public Police() {
        suspects = new ArrayList<>();
        statistics = new HashMap<>();

    }

    public static void main(String[] args) {

        Police police = new Police();
        police.simulate(300, 54);

    }

    public void simulate(int nrOfSuspects, int nrOfSimulate) {
        int i = 0;
        while (i != nrOfSuspects) {
            int random = (int) (Math.random() * 5 + 1);
            switch (random) {
                case 1:
                    suspects.add(new BadGuy());
                    break;
                case 2:
                    suspects.add(new Naive());
                    break;
                case 3:
                    suspects.add(new TitForTat());
                    break;
                case 4:
                    suspects.add(new Prejudiced());
                    break;
                case 5:
                    suspects.add(new Random());
                    break;
            }
            i++;
        }
        i = 0;
        while (i != nrOfSimulate) {
            investigate();
            i++;
        }
        theBestType();

    }

    public void investigate() {
        boolean s1;
        boolean s2;
        for (int i = 0; i < suspects.size(); i++) {
            for (int j = i + 1; j < suspects.size() - 1; j++) {
                s1 = suspects.get(i).confess(suspects.get(j));
                s2 = suspects.get(j).confess(suspects.get(i));
                if (s1 && !s2) {
                    suspects.get(i).setPunishment(suspects.get(j), 0);
                    suspects.get(j).setPunishment(suspects.get(i), 3);
                    statistics.putIfAbsent(suspects.get(i), 0);
                    statistics.put(suspects.get(i),  Integer.sum(statistics.get(suspects.get(i)),0));
                    statistics.putIfAbsent(suspects.get(j), 0);
                    statistics.put(suspects.get(j), Integer.sum(statistics.get(suspects.get(j)),-3));
                } else if (!s1 && !s2) {
                    suspects.get(i).setPunishment(suspects.get(j), 1);
                    suspects.get(j).setPunishment(suspects.get(i), 1);
                    statistics.putIfAbsent(suspects.get(i), 0);
                    statistics.put(suspects.get(i), Integer.sum(statistics.get(suspects.get(i)),-1));
                    statistics.putIfAbsent(suspects.get(j), 0);
                    statistics.put(suspects.get(j), Integer.sum(statistics.get(suspects.get(j)),-1));
                } else if (s1) {
                    suspects.get(i).setPunishment(suspects.get(j), 2);
                    suspects.get(j).setPunishment(suspects.get(i), 2);
                    statistics.putIfAbsent(suspects.get(i), 0);
                    statistics.put(suspects.get(i), Integer.sum(statistics.get(suspects.get(i)),-2));
                    statistics.putIfAbsent(suspects.get(j), 0);
                    statistics.put(suspects.get(j), Integer.sum(statistics.get(suspects.get(j)),-2));
                } else {
                    suspects.get(i).setPunishment(suspects.get(j), 3);
                    suspects.get(j).setPunishment(suspects.get(i), 0);
                    statistics.putIfAbsent(suspects.get(i),0);
                    statistics.put(suspects.get(i), Integer.sum(statistics.get(suspects.get(i)),-3));
                    statistics.putIfAbsent(suspects.get(j), 0);
                    statistics.put(suspects.get(j),Integer.sum(statistics.get(suspects.get(j)),0));
                }
            }
        }
    }

    public void theBestType(){
        int badGuyCounter = 0;
        int naiveCounter = 0;
        int titForTatCounter = 0;
        int prejudicedCounter = 0;
        int randomCounter = 0;
        int max = Integer.MIN_VALUE;
        String result = null;
        TreeMap<String,Integer> bestType = new TreeMap<>();
        for (Suspect suspect : statistics.keySet()) {
            if (suspect instanceof BadGuy){
                badGuyCounter += statistics.get(suspect);
            }
            else if (suspect instanceof Naive){
                naiveCounter += statistics.get(suspect);
            }
            else if (suspect instanceof  TitForTat){
                titForTatCounter += statistics.get(suspect);
            }
            else if (suspect instanceof Prejudiced){
                prejudicedCounter += statistics.get(suspect);
            }
            else {
                randomCounter += statistics.get(suspect);
            }

        }
        bestType.putIfAbsent("BadGuy",badGuyCounter);
        bestType.putIfAbsent("Naive" , naiveCounter);
        bestType.putIfAbsent("Tit for Tat",titForTatCounter);
        bestType.putIfAbsent("Prejudiced",prejudicedCounter);
        bestType.putIfAbsent("Random",randomCounter);

        for (String s : bestType.keySet()) {
            if (bestType.get(s) > max){
                max = bestType.get(s);
                result = s;
            }
        }
        System.out.println("A legoptimálisabb stratégia: " + result + " kapott pontok(évek): " + max);

    }

}