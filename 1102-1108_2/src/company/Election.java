package com.company;

public class Election {
    private int nrOfDistrict;
    private int votes;
    private String name;
    private String support;

    public Election(int nrOfDistrict, int votes, String name, String support) {
        this.nrOfDistrict = nrOfDistrict;
        this.votes = votes;
        this.name = name;
        this.support = support;
    }

    public int getNrOfDistrict() {
        return nrOfDistrict;
    }

    public void setNrOfDistrict(int nrOfDistrict) {
        this.nrOfDistrict = nrOfDistrict;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "Election{" +
                "nrOfDistrict=" + nrOfDistrict +
                ", votes=" + votes +
                ", name='" + name + '\'' +
                ", support='" + support + '\'' +
                '}';
    }
}
