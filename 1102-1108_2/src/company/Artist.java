package com.company;

import java.util.List;

public class Artist {

    private String name;
    private int awardYear;
    private String highestAward;
    private List<String> professions;

    public Artist(String name, int awardYear, String highestAward, List<String> professions) {
        this.name = name;
        this.awardYear = awardYear;
        this.highestAward = highestAward;
        this.professions = professions;
    }

    public Artist(String name, int awardYear, List<String> professions) {
        this.name = name;
        this.awardYear = awardYear;
        this.professions = professions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAwardYear() {
        return awardYear;
    }

    public void setAwardYear(int awardYear) {
        this.awardYear = awardYear;
    }

    public String getHighestAward() {
        return highestAward;
    }

    public void setHighestAward(String highestAward) {
        this.highestAward = highestAward;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    @Override
    public String toString() {
        return "HungarianAward{" +
                "name='" + name + '\'' +
                ", awardYear=" + awardYear +
                ", highestAward='" + highestAward + '\'' +
                ", professions=" + professions +
                '}';
    }

}
