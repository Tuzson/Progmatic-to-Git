package company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class User {
   private int Id;
   private String name;
   private String gender;
   private int age;
   private String hairColor;
   private String eyeColor;
   private HashSet<User> likedUsers = new LinkedHashSet<>();
   private Set<User> disLikedUsers = new LinkedHashSet<>();
   private int nrOfLikeToGet = 0;
   private int getNrOfDisLikeToGet= 0;

    public User(int Id, String name, String gender, int age, String hairColor, String eyeColor) {
        this.Id = Id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LinkedHashSet<User> getLikedUsers() {
        return (LinkedHashSet<User>) likedUsers;
    }

    public void setLikedUsers(Set<User> likedUsers) {
        this.likedUsers = (HashSet<User>) likedUsers;
    }

    public Set<User> getDisLikedUsers() {
        return disLikedUsers;
    }

    public void setDisLikedUsers(Set<User> disLikedUsers) {
        this.disLikedUsers = disLikedUsers;
    }

    public int getNrOfLikeToGet() {
        return nrOfLikeToGet;
    }

    public void setNrOfLikeToGet(int nrOfLikeToGet) {
        this.nrOfLikeToGet = nrOfLikeToGet;
    }

    public int getGetNrOfDisLikeToGet() {
        return getNrOfDisLikeToGet;
    }

    public void setGetNrOfDisLikeToGet(int getNrOfDisLikeToGet) {
        this.getNrOfDisLikeToGet = getNrOfDisLikeToGet;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }


}
