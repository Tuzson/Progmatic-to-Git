package com.company.PrisonerDilemma;

import java.util.HashMap;

public class Prejudiced extends SuspectProfile {
    public Prejudiced() {
        super("Prejudiced" + " " + (int)(Math.random()*100));

    }

    @Override
    public boolean confess(Suspect other) {
        return cooperations.size() <= noncoperations.size();
    }

    @Override
    public void setPunishment(Suspect other, int year) {
        if (noncoperations.containsKey(other) && year == 0) {
            cooperations.put(other, noncoperations.get(other));
            noncoperations.remove(other);
        } else if (year == 0) {
            cooperations.putIfAbsent(other, year);
            cooperations.put(other, -year);
        } else if (noncoperations.containsKey(other) && year == 1) {
            cooperations.put(other, noncoperations.get(other) - 1);
            noncoperations.remove(other);
        } else if (year == 1) {
            cooperations.putIfAbsent(other, year);
            cooperations.put(other, -year);
        } else if (cooperations.containsKey(other) && year == 2) {
            noncoperations.put(other, cooperations.get(other) - 2);
            cooperations.remove(other);
        } else if (year == 2) {
            noncoperations.putIfAbsent(other, year);
            noncoperations.put(other, -year);
        } else if (cooperations.containsKey(other) && year == 3) {
            noncoperations.put(other, cooperations.get(other) - 2);
            cooperations.remove(other);
        } else if (year == 3) {
            noncoperations.putIfAbsent(other, year);
            noncoperations.put(other, -year);
        }

    }
}
