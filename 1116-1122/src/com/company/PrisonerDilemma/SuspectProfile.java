package com.company.PrisonerDilemma;

import java.util.HashMap;
import java.util.Map;

public abstract class SuspectProfile implements Suspect {
    Map<Suspect, Integer> cooperations;
    Map<Suspect, Integer> noncoperations;

    public SuspectProfile() {

        cooperations = new HashMap<>();
        noncoperations = new HashMap<>();
    }

}
