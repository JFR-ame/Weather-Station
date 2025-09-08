package main;
import displays.CurrentConditionsDisplay;
import displays.ForecastDisplay;
import displays.HeatIndexDisplay;
import displays.PressureDisplay;
import displays.StatisticsDisplay;
import weather.WeatherData;
public class WeatherStation {
	public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        new CurrentConditionsDisplay(weatherData);
        new StatisticsDisplay(weatherData);
        new ForecastDisplay(weatherData);
        new PressureDisplay(weatherData);
        new HeatIndexDisplay(weatherData);

        System.out.println("=== Primera actualización ===");
        weatherData.setMeasurements(30, 65, 1012);

        System.out.println("\n=== Segunda actualización ===");
        weatherData.setMeasurements(32, 70, 1010);

        System.out.println("\n=== Tercera actualización ===");
        weatherData.setMeasurements(28, 90, 1008);
    }
}

