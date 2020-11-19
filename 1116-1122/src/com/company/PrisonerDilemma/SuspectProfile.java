package com.company.PrisonerDilemma;

import java.util.HashMap;
import java.util.Map;

public abstract class SuspectProfile implements Suspect {
    String name;
    Map<Suspect, Integer> cooperations;
    Map<Suspect, Integer> noncoperations;

    public SuspectProfile(String name) {
        this.name = name;
        cooperations = new HashMap<>();
        noncoperations = new HashMap<>();
    }

    @Override
    public String toString() {
        return "SuspectProfile{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
