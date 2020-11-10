package com.company;

import java.util.ArrayList;

public class Country {
    private String countryCode;
    private String countryName;
    private String Continent;
    private String Region;
    private float landSize;
    private int freedomYear;
    private int population;
    private String nameOfThePresident;
    private ArrayList<City> cities = new ArrayList<>();

    public Country(String countryCode, String countryName, String continent, String region, float landSize, int freedomYear, int population, String nameOfThePresident) {

        this.countryCode = countryCode;
        this.countryName = countryName;
        Continent = continent;
        Region = region;
        this.landSize = landSize;
        this.freedomYear = freedomYear;
        this.population = population;
        this.nameOfThePresident = nameOfThePresident;

    }

    public Country(String countryCode, String countryName, String continent, String region, float landSize, int freedomYear, int population) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        Continent = continent;
        Region = region;
        this.landSize = landSize;
        this.freedomYear = freedomYear;
        this.population = population;
    }


    public String getCountryCode() {
        return countryCode;
    }


    public String getCountryName() {
        return countryName;
    }



    public String getContinent() {
        return Continent;
    }








    public int getFreedomYear() {
        return freedomYear;
    }



    public int getPopulation() {
        return population;
    }



    public String getNameOfThePresident() {
        return nameOfThePresident;
    }



    public ArrayList<City> getCities() {
        return cities;
    }


    @Override
    public String toString() {
        return "Country{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", Continent='" + Continent + '\'' +
                ", Region='" + Region + '\'' +
                ", landSize=" + landSize +
                ", freedomYear=" + freedomYear +
                ", population=" + population +
                ", nameOfThePresident='" + nameOfThePresident + '\'' +
                ", cities=" + cities +
                '}';
    }

    public double getPopulationDensity() {
        return population / landSize;
    }

    public double getRuralPopulation() {
        double sum = population;
        for (City city : cities) {
            sum -= city.getPopulation();
        }
        return sum;
    }

}