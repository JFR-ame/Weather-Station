package displays;
import observer.Observer;
import subject.Subject;
public class ForecastDisplay implements Observer, DisplayElement {
    private float lastPressure;
    private float currentPressure = 1013.25f; // presión estándar
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        if (currentPressure > lastPressure) {
            System.out.println("Pronóstico: Mejorando el clima!");
        } else if (currentPressure == lastPressure) {
            System.out.println("Pronóstico: Más de lo mismo.");
        } else {
            System.out.println("Pronóstico: Se avecina lluvia.");
        }
    }
}
