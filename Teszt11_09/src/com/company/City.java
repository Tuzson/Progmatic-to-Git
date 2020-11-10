package com.company;


public class City {
    private String cityName;
    private String countryCode;
    private int population;
    private Country country;

    public City(String cityName, String countryCode, int population) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.population = population;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getPopulation() {
        return population;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", population=" + population +
                '}';
    }

    public double getPopulationPercentage() {
        double percent;
        percent = (getPopulation() / (double) getCountry().getPopulation()) * 100;

        return percent;
    }

}
