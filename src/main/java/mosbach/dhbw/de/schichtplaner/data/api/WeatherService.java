package mosbach.dhbw.de.schichtplaner.data.api;

import mosbach.dhbw.de.schichtplaner.model.WeatherResponse;

public interface WeatherService {
    WeatherResponse fetchWeatherData(String date);
}
