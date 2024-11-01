package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.WeatherService;
import mosbach.dhbw.de.schichtplaner.data.impl.WeatherServiceImpl;
import mosbach.dhbw.de.schichtplaner.model.WeatherResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "https://eventcalender-sleepy-wallaby-ri.apps.01.cf.eu01.stackit.cloud/", allowedHeaders = "*")
public class WeatherController {
    private final WeatherService weatherService = new WeatherServiceImpl();

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam(value = "date", required = false) String date) {
        WeatherResponse weatherData = weatherService.fetchWeatherData(date);
        return ResponseEntity.ok(weatherData);
    }

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }
}
