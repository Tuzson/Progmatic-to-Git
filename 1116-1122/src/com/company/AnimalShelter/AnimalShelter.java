package com.company.AnimalShelter;

import java.util.ArrayList;

public class AnimalShelter {
    private int budget;
    private ArrayList<Animal> animals;
    private ArrayList<String> adoptersName;

    public AnimalShelter() {
        budget = 50;
        animals = new ArrayList<>();
        adoptersName = new ArrayList<>();
    }

    public void rescue(Animal animal){
        int nrOfAnimal = 0;
        animals.add(animal);
        nrOfAnimal++;
        System.out.println("Az állatok száma a menhelyen:" + animals.size());

    }

    public int heal (){
        int nrOfHealedAnimal = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (!animals.get(i).isHealthy){
                if (budget >= animals.get(i).getHealCost()){
                    animals.get(i).heal();
                    nrOfHealedAnimal++;
                    break;
                }
                break;
            }
        }
        return nrOfHealedAnimal;
    }
    public void addAdopter(String name){
        adoptersName.add(name);

    }

    public void findNewOwner(){

        int random = (int)(Math.random()*5000);
        String ownerName = "Owner" + random;
        addAdopter(ownerName);

        if (animals.size() > 0 ){
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).isAdoptable()){
                    animals.get(i).ownerName =ownerName;
                    animals.remove(i);
                    adoptersName.remove(0);
                    break;
                }
            }



        }
    }

    public int earnDonation (int amount){
        budget+= amount;

        return budget;
    }

    @Override
    public String toString() {
        return "Budget: " + budget + "€ \n There are " + animals.size() + " animal(s) and " + adoptersName.size() + " potential adopter(s)";
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<String> getAdoptersName() {
        return adoptersName;
    }
}
