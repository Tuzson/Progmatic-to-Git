package com.company;

public abstract class Animal {
    protected String type;
    protected String livingArea;
    protected int age;

    public Animal(String type, String livingArea, int age) {
        this.type = type;
        this.livingArea = livingArea;
        this.age = age;
    }

    public abstract void voice();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", livingArea='" + livingArea + '\'' +
                ", age=" + age +
                '}';
    }
}
