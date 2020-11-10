package company;

import java.util.ArrayList;

public class PetOwner {
    private String name;
    private int age;
    private String gender;
    private ArrayList<Integer> petId;
    private int petCount;
    private Pet favoritePet;
    private ArrayList<Pet> pets = new ArrayList<>();

    public PetOwner(String name, int age, String gender, ArrayList<Integer> petId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Integer> getPetId() {
        return petId;
    }

    public void setPetId(ArrayList<Integer> petId) {
        this.petId = petId;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(Pet pets) {
        this.pets.add(pets);
    }

    public int getPetCount() {
        return petCount;
    }

    public Pet getFavoritePet() {
        return favoritePet;
    }

    public void setPetCount(int petCount) {
        this.petCount = petCount;
    }

    public void setFavoritePet(Pet favoritePet) {
        this.favoritePet = favoritePet;
    }

    @Override
    public String toString() {
        return "PetOwner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", petId=" + petId +
                ", petCount=" + petCount +
                ", favoritePet=" + favoritePet +
                ", pets=" + pets +
                '}';
    }
}
