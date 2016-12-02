package me.acmh.sweaterweather.data;

public class City {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }


    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public City(String nome, double maxTemperature, double minTemperature, String weatherDescription, String iconName) {
        this.nome = nome;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.weatherDescription = weatherDescription;
        this.iconName = iconName;
    }

    private String nome;
    private double maxTemperature;
    private double minTemperature;
    private String weatherDescription;
    private String iconName;

}
