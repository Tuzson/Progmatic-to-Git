package company;

import java.util.ArrayList;
import java.util.Objects;

public class Animal2 {
    private String species;
    private ArrayList<String> lifeArea;

    public Animal2(String species, ArrayList<String> lifeArea) {
        this.species = species;
        this.lifeArea = lifeArea;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public ArrayList<String> getLifeArea() {
        return lifeArea;
    }

    public void setLifeArea(ArrayList<String> lifeArea) {
        this.lifeArea = lifeArea;
    }

    @Override
    public String toString() {
        return "Animal2{" +
                "species='" + species + '\'' +
                ", lifeArea=" + lifeArea +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal2 animal2 = (Animal2) o;
        return Objects.equals(species, animal2.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species);
    }
}
