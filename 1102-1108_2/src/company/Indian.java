/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.progmatic.exercises.datastructures.indians;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author peti
 */
public class Indian implements Comparable<Indian> {

    private final String name;
    private final int age;
    private final String tribe;
    private final boolean isFemale;
    private final List<String> posessions = new ArrayList<>();

    public Indian(String lineOfFile) {
        String[] splitted = lineOfFile.split(",");
        this.name = splitted[0];
        this.tribe = splitted[1];
        this.isFemale = "n".equals(splitted[2]);
        this.age = Integer.valueOf(splitted[3]);
        String[] posss = splitted[4].split("\\|");
        posessions.addAll(Arrays.asList(posss));
    }

    public Indian(String name, int age, String tribe, boolean isFemale) {
        this.name = name;
        this.age = age;
        this.tribe = tribe;
        this.isFemale = isFemale;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTribe() {
        return tribe;
    }

    public boolean isIsFemale() {
        return isFemale;
    }

    public List<String> getPosessions() {
        return posessions;
    }

    @Override
    public String toString() {
        return "Indian{" + "name=" + name + ", age=" + age + ", tribe=" + tribe + ", isFemale=" + isFemale + ", posessions=" + posessions + '}';
    }

    @Override
    public int compareTo(Indian indian) {
        if (this.age == indian.age) {
            return this.name.compareTo(indian.name);

        }
        return this.age-indian.age;

    }

}
