package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Indian {
    private String name;
    private String tribe;
    private String gender;
    private Integer age;
    private List<String> equipments;

    public Indian(String name, String tribe, String gender, Integer age, List<String> equipments) throws FileNotFoundException {
        this.name = name;
        this.tribe = tribe;
        this.gender = gender;
        this.age = age;
        this.equipments = equipments;

    }

    @Override
    public String toString() {
        return "Indian{" +
                "name='" + name + '\'' +
                ", tribe='" + tribe + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", equipments=" + equipments +
                '}';
    }

    public String getGender () {
            return gender;
        }

        public void setGender (String gender){
            this.gender = gender;
        }

        public Integer getAge () {
            return age;
        }

        public void setAge (Integer age){
            this.age = age;
        }

        public List<String> getEquipments () {
            return equipments;
        }

        public void setEquipments (List < String > equipments) {
            this.equipments = equipments;

        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getTribe () {
            return tribe;
        }

        public void setTribe (String tribe){
            this.tribe = tribe;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indian indian = (Indian) o;
        return Objects.equals(tribe, indian.tribe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tribe);
    }
}
