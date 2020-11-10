package company;

import java.util.List;

public class Animal {

private String species;
private String type;
private double averageWeight;
private double maxSpeed;
private double averageAge;
private List<String> lifeArea;

    public Animal(String species, String type, double averageWeight, double maxSpeed, double averageAge) {
        this.species = species;
        this.type = type;
        this.averageWeight = averageWeight;
        this.maxSpeed = maxSpeed;
        this.averageAge = averageAge;
//        this.lifeArea = lifeArea;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public List<String> getLifeArea() {
        return lifeArea;
    }

    public void setLifeArea(List<String> lifeArea) {
        this.lifeArea = lifeArea;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", averageWeight=" + averageWeight +
                ", maxSpeed=" + maxSpeed +
                ", averageAge=" + averageAge +
                ", lifeArea=" + lifeArea +
                '}';
    }
}
