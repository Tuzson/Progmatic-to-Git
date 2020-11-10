package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Boxer {
    private String name;
    private String nation;
    private Integer weight;
    private Integer nrOfLossPerDay;
    private Integer nrOfMaxLoss;
    private Integer nrOfWeightCategory;

    public Boxer(String name,String nation ,Integer weight, Integer nrOfLossPerDay, Integer nrOfMaxLoss) {
        this.name = name;
        this.nation = nation;
        this.weight = weight;
        this.nrOfLossPerDay = nrOfLossPerDay;
        this.nrOfMaxLoss = nrOfMaxLoss;
        nrOfWeightCategory = myWeightCategory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getNrOfLossPerDay() {
        return nrOfLossPerDay;
    }

    public void setNrOfLossPerDay(Integer nrOfLossPerDay) {
        this.nrOfLossPerDay = nrOfLossPerDay;
    }

    public Integer getNrOfMaxLoss() {
        return nrOfMaxLoss;
    }

    public void setNrOfMaxLoss(Integer nrOfMaxLoss) {
        this.nrOfMaxLoss = nrOfMaxLoss;
    }

    public Integer getNrOfWeightCategory() {
        return nrOfWeightCategory;
    }

    public void setNrOfWeightCategory(Integer nrOfWeightCategory) {
        this.nrOfWeightCategory = nrOfWeightCategory;
    }

    @Override
    public String toString() {
        return "Boxer{" +
                "name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", weight=" + weight +
                ", nrOfLossPerDay=" + nrOfLossPerDay +
                ", nrOfMaxLoss=" + nrOfMaxLoss +
                ", nrOfWeightCategory=" + nrOfWeightCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boxer boxer = (Boxer) o;
        return Objects.equals(weight, boxer.weight) &&
                Objects.equals(nrOfWeightCategory, boxer.nrOfWeightCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, nrOfWeightCategory);
    }

    public int myWeightCategory() {
         int[] weightCategories = new int[]{52, 57, 63, 71, 79, 91};
         int i = 0;
        for (i = 0; i < weightCategories.length; i++) {
          if (weight <= weightCategories[i]){
              return i;
            }
         else if (weight > weightCategories[weightCategories.length-1]){
             return weightCategories.length;
          }
        }
        return -1;
        }
    }

