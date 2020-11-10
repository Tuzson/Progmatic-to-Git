package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        WorldStatistics ws = new WorldStatistics();

        //1.feladat
        //Country létrehozva, hivatkozik City-re.
        // City létrehozva, hivatkozik Country-ra.
        // WordStatistics létrehozva, file beolvasva (máshogy mint a feladat kéri). Országok, városok feltöltve adatokkal.

        //2. feladat
        String country = "Aruba";
        int i = getTheCountryNr(country);
        System.out.println(ws.getCountries().get(i).getPopulationDensity() + " fő/km2 " + country + " népsűrűsége.");

        //3. feladat
        country = "Croatia";
        i = getTheCountryNr(country);
        System.out.println(ws.getCountries().get(i).getRuralPopulation() + " fő él a felsorolt városokon kívül.");

        //4.feladat
        System.out.println(ws.findCountryByISoCode("HUN"));

        //5.feladat
        System.out.println(ws.getCountriesOfContinent("Europe"));

        //6.feladat
        System.out.println(ws.getCitiesOfCountry("HUN"));

        //7.feladat
        System.out.println(ws.getAhmedCount() + " államfő nevében szerepel a 'Hamad', 'Ahmad' vagy az 'Ahmed' ");

        //8.feladat
        System.out.println(ws.getPopularFirstLetter() + " betűvel kezdődik a legtöbb országkód.");

        //9.feladat
        System.out.println(ws.lastIndependentCountry() + " nyerte el legkésőbb a függetlenségét.");

        //10.feladat
        String city = "Budapest";
        i = getTheCityNr(city);
        System.out.println(city + " populációja, " + ws.getCities().get(i).getPopulationPercentage() + " %-a " + ws.getCities().get(i).getCountry().getCountryName() + " populációjának.");

    }

    public static int getTheCountryNr(String s) throws FileNotFoundException {
        WorldStatistics ws = new WorldStatistics();
        int nr = 0;
        for (int i = 0; i < ws.getCountries().size(); i++) {
            if (ws.getCountries().get(i).getCountryName().equals(s)) {
                nr = i;
                break;
            }
        }
        return nr;
    }

    public static int getTheCityNr(String s) throws FileNotFoundException {
        WorldStatistics ws = new WorldStatistics();
        int nr = 0;
        for (int i = 0; i < ws.getCities().size(); i++) {
            if (ws.getCities().get(i).getCityName().equals(s)) {
                nr = i;
                break;
            }

        }
        return nr;
    }
}