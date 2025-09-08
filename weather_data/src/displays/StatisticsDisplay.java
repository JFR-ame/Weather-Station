package displays;
import java.util.*;
import observer.Observer;
import subject.Subject;
public class StatisticsDisplay implements Observer, DisplayElement {
    private List<Float> tempHistory = new ArrayList<>();
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        tempHistory.add(temp);
        display();
    }

    @Override
    public void display() {
        float avg = (float) tempHistory.stream().mapToDouble(Float::doubleValue).average().orElse(0.0);
        System.out.println("Estadísticas -> Temp promedio: " + avg + "°C");
    }
}

