package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class WorldStatistics {

   private ArrayList<Country> countries = new ArrayList<>();
   private ArrayList<City> cities = new ArrayList<>();


    public WorldStatistics() throws FileNotFoundException {
        readFile(countries, cities);
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }


    public ArrayList<City> getCities() {
        return cities;
    }



    public void readFile(ArrayList<Country> countries, ArrayList<City> cities) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Txt files/orszagok.txt"));

        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");
            if (data.length > 7 && data[5].equals("NULL")) {
                int integer = 0;
                countries.add(new Country(data[0], data[1], data[2], data[3], Float.parseFloat(data[4]), integer, Integer.parseInt(data[6]), data[7]));
            } else if (data.length > 7) {
                countries.add(new Country(data[0], data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), data[7]));
            } else if (data[5].equals("NULL")) {
                int integer = 0;
                countries.add(new Country(data[0], data[1], data[2], data[3], Float.parseFloat(data[4]), integer, Integer.parseInt(data[6])));
            } else {
                countries.add(new Country(data[0], data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));

            }

        }
        Scanner ss = new Scanner(new File("Txt files/varosok.txt"));
        while (ss.hasNextLine()) {
            String[] data = ss.nextLine().split(",");
            cities.add(new City(data[0], data[1], Integer.parseInt(data[2])));
        }

        for (Country country : countries) {
            for (City city : cities) {
                if (country.getCountryCode().equals(city.getCountryCode())) {
                    country.getCities().add(city);
                    city.setCountry(country);
                }
            }
        }

    }

    @Override
    public String toString() {
        return "WorldStatistics{" +
                "countries=" + countries +
                ", cities=" + cities +
                '}';
    }

    public Country findCountryByISoCode(String isoCode) {
        Country countryData = null;
        for (Country country : countries) {
            if (country.getCountryCode().equals(isoCode)) {
                countryData = country;
            }
        }
        return countryData;
    }

    public ArrayList<String> getCountriesOfContinent(String continentName) {
        ArrayList<String> countryCodes = new ArrayList<>();
        for (Country country : countries) {
            if (country.getContinent().equals(continentName)) {
                countryCodes.add(country.getCountryCode());
            }
        }
        return countryCodes;

    }

    public HashSet<String> getCitiesOfCountry(String countryCode) {
        HashSet<String> hash = new HashSet<>();
        for (Country country : countries) {
            for (int j = 0; j < country.getCities().size(); j++) {
                if (country.getCountryCode().equals(countryCode)) {
                    hash.add(country.getCities().get(j).getCityName());
                }
            }

        }
        return hash;
    }

    public int getAhmedCount() {
        int nrOfPresident = 0;

        for (Country country : countries) {
            if (country.getNameOfThePresident() != null) {
                String name = country.getNameOfThePresident();
                int hamadNr = name.indexOf("Hamad");
                int ahmadNr = name.indexOf("Ahmad");
                int ahmedNr = name.indexOf("Ahmed");

                if (hamadNr != -1 || ahmadNr != -1 || ahmedNr != -1) {
                    nrOfPresident++;
                }
            }
        }
        return nrOfPresident;
    }

    public String getPopularFirstLetter() {
        String result = null;
        int counter = 0;
        int max = 0;
        String ch;
        for (int i = 0; i < countries.size(); i++) {
            ch = countries.get(i).getCountryCode().substring(0, 1);
            for (int j = i; j < countries.size(); j++) {
                if (countries.get(j).getCountryCode().substring(0, 1).equals(ch)) {
                    counter++;
                } else {
                    if (counter > max) {
                        max = counter;
                        result = ch;
                    }
                    counter = 0;
                    break;
                }
            }
        }
        return result;

    }

    public String lastIndependentCountry() {
        String countryCode = null;
        int freedomYear = 0;

        for (Country country : countries) {
            if (country.getFreedomYear() > 0 && country.getFreedomYear() > freedomYear) {
                freedomYear = country.getFreedomYear();
                countryCode = country.getCountryCode();

            }
        }
        return countryCode;
    }

}
