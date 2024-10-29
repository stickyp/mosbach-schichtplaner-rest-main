package mosbach.dhbw.de.schichtplaner.model;

public class CurrentWeather {
    private String time;
    private double precipitation;
    private double windSpeed10m;

    // Getters and Setters
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getWindSpeed10m() {
        return windSpeed10m;
    }

    public void setWindSpeed10m(double windSpeed10m) {
        this.windSpeed10m = windSpeed10m;
    }
}
