package me.acmh.sweaterweather.data;

public class City {
    public City(String nome, String maxTemperature, String minTemperature, String weatherDescription) {
        this.nome = nome;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.weatherDescription = weatherDescription;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    private String nome;
    private String maxTemperature;
    private String minTemperature;
    private String weatherDescription;

}
