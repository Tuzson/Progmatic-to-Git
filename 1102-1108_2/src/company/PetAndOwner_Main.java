package com.company;

import java.io.FileNotFoundException;

public class PetAndOwner_Main {
    public static void main(String[] args) throws FileNotFoundException {

        PetOwnerMerge a = new PetOwnerMerge();
        a.fillupOwners();
        a.fillUpPets();

    }
}
