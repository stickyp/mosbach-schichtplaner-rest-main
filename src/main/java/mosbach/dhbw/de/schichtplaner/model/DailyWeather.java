package mosbach.dhbw.de.schichtplaner.model;

import java.util.List;

public class DailyWeather {
    private List<String> time;
    private List<Double> temperature2mMax;
    private List<Double> temperature2mMin;

    // Getters and Setters
    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Double> getTemperature2mMax() {
        return temperature2mMax;
    }

    public void setTemperature2mMax(List<Double> temperature2mMax) {
        this.temperature2mMax = temperature2mMax;
    }

    public List<Double> getTemperature2mMin() {
        return temperature2mMin;
    }

    public void setTemperature2mMin(List<Double> temperature2mMin) {
        this.temperature2mMin = temperature2mMin;
    }
}
