package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Indian {
    private String name;
    private String tribe;
    private IndianGender genderEnum;
    private Integer age;
    private List<String> equipments;

    public Indian(String name, String tribe, IndianGender genderEnum, Integer age, List<String> equipments) {
        this.name = name;
        this.tribe = tribe;
        this.genderEnum = genderEnum;
        this.age = age;
        this.equipments = equipments;
    }

    @Override
    public String toString() {
        return "Indian{" +
                "name='" + name + '\'' +
                ", tribe='" + tribe + '\'' +
                ", genderEnum=" + genderEnum +
                ", age=" + age +
                ", equipments=" + equipments +
                '}';
    }

    public IndianGender getGenderEnum() {
        return genderEnum;
    }

    public void setGenderEnum(IndianGender genderEnum) {
        this.genderEnum = genderEnum;
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
