package company;

import java.util.Objects;

public class Pet {
    private int id;
    private String name;
    private String species;
    private int age;
    private PetOwner owner;
    private boolean isFavorite;
    private boolean isOlderThanOwner;

    public Pet(int id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PetOwner getOwner() {
        return owner;
    }

    public void setOwner(PetOwner owner) {
        this.owner = owner;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", isFavorite=" + isFavorite +
                ", isOlderThanOwner=" + isOlderThanOwner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public boolean isOlderThanOwner() {
        return isOlderThanOwner;
    }

    public void setOlderThanOwner(boolean olderThanOwner) {
        isOlderThanOwner = olderThanOwner;
    }
}