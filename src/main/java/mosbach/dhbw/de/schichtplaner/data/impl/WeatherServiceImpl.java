package mosbach.dhbw.de.schichtplaner.data.impl;

import com.google.gson.Gson;
import mosbach.dhbw.de.schichtplaner.data.api.WeatherService;
import mosbach.dhbw.de.schichtplaner.model.WeatherResponse;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherServiceImpl implements WeatherService {
    private static final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude=49.2529&longitude=8.8787&current=precipitation,wind_speed_10m&daily=temperature_2m_max,temperature_2m_min&timezone=Europe%2FBerlin&forecast_days=1";

    @Override
    public WeatherResponse fetchWeatherData(String date) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code: " + connection.getResponseCode());
            }

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            WeatherResponse weatherResponse = new Gson().fromJson(reader, WeatherResponse.class);
            reader.close();
            return weatherResponse;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
