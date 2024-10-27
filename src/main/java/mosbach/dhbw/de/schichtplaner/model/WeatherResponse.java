package mosbach.dhbw.de.schichtplaner.model;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * WeatherResponse
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "temperatureMin",
        "temperatureMax",
        "precipitation",
        "windSpeed"
})
public class WeatherResponse {

    /**
     * The date of the weather forecast
     * (Required)
     *
     */
    @JsonProperty("date")
    @JsonPropertyDescription("The date of the weather forecast")
    @NotNull
    private String date;
    /**
     * The minimum temperature for the day
     * (Required)
     *
     */
    @JsonProperty("temperatureMin")
    @JsonPropertyDescription("The minimum temperature for the day")
    @NotNull
    private Double temperatureMin;
    /**
     * The maximum temperature for the day
     * (Required)
     *
     */
    @JsonProperty("temperatureMax")
    @JsonPropertyDescription("The maximum temperature for the day")
    @NotNull
    private Double temperatureMax;
    /**
     * The probability of precipitation
     * (Required)
     *
     */
    @JsonProperty("precipitation")
    @JsonPropertyDescription("The probability of precipitation")
    @NotNull
    private Double precipitation;
    /**
     * The wind speed for the day
     * (Required)
     *
     */
    @JsonProperty("windSpeed")
    @JsonPropertyDescription("The wind speed for the day")
    @NotNull
    private Double windSpeed;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public WeatherResponse() {
    }

    /**
     *
     * @param date
     * The date of the weather forecast.
     * @param precipitation
     * The probability of precipitation.
     * @param temperatureMax
     * The maximum temperature for the day.
     * @param temperatureMin
     * The minimum temperature for the day.
     * @param windSpeed
     * The wind speed for the day.
     */
    public WeatherResponse(String date, Double temperatureMin, Double temperatureMax, Double precipitation, Double windSpeed) {
        super();
        this.date = date;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
    }

    /**
     * The date of the weather forecast
     * (Required)
     *
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * The date of the weather forecast
     * (Required)
     *
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * The minimum temperature for the day
     * (Required)
     *
     */
    @JsonProperty("temperatureMin")
    public Double getTemperatureMin() {
        return temperatureMin;
    }

    /**
     * The minimum temperature for the day
     * (Required)
     *
     */
    @JsonProperty("temperatureMin")
    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    /**
     * The maximum temperature for the day
     * (Required)
     *
     */
    @JsonProperty("temperatureMax")
    public Double getTemperatureMax() {
        return temperatureMax;
    }

    /**
     * The maximum temperature for the day
     * (Required)
     *
     */
    @JsonProperty("temperatureMax")
    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    /**
     * The probability of precipitation
     * (Required)
     *
     */
    @JsonProperty("precipitation")
    public Double getPrecipitation() {
        return precipitation;
    }

    /**
     * The probability of precipitation
     * (Required)
     *
     */
    @JsonProperty("precipitation")
    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * The wind speed for the day
     * (Required)
     *
     */
    @JsonProperty("windSpeed")
    public Double getWindSpeed() {
        return windSpeed;
    }

    /**
     * The wind speed for the day
     * (Required)
     *
     */
    @JsonProperty("windSpeed")
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}