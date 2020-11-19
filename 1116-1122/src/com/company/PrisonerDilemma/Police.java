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
        police.simulate(50, 3);

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
        System.out.println(statistics);

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
                    statistics.put(suspects.get(i), -0);
                    statistics.putIfAbsent(suspects.get(j), 3);
                    statistics.put(suspects.get(j), -3);
                } else if (!s1 && !s2) {
                    suspects.get(i).setPunishment(suspects.get(j), 1);
                    suspects.get(j).setPunishment(suspects.get(i), 1);
                    statistics.putIfAbsent(suspects.get(i), 1);
                    statistics.put(suspects.get(i), -1);
                    statistics.putIfAbsent(suspects.get(j), 1);
                    statistics.put(suspects.get(j), -1);
                } else if (s1) {
                    suspects.get(i).setPunishment(suspects.get(j), 2);
                    suspects.get(j).setPunishment(suspects.get(i), 2);
                    statistics.putIfAbsent(suspects.get(i), 2);
                    statistics.put(suspects.get(i), -2);
                    statistics.putIfAbsent(suspects.get(j), 2);
                    statistics.put(suspects.get(j), -2);
                } else {
                    suspects.get(i).setPunishment(suspects.get(j), 3);
                    suspects.get(j).setPunishment(suspects.get(i), 0);
                    statistics.putIfAbsent(suspects.get(i), 3);
                    statistics.put(suspects.get(i), -3);
                    statistics.putIfAbsent(suspects.get(j), 0);
                    statistics.put(suspects.get(j), -0);
                }
            }
        }
    }

}
