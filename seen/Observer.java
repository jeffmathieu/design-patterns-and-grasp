package seen;

interface WeatherObserver {
    void update(int temperature);
}
class WeatherStation {
    private int temperature;

    private final java.util.List<WeatherObserver> observers = new java.util.ArrayList<>();

    public void addObserver(WeatherObserver o) { observers.add(o); }

    public void removeObserver(WeatherObserver o) { observers.remove(o); }

    public void setTemperature(int t) {
        this.temperature = t;
        for (WeatherObserver o : observers) o.update(t);
    }
}
public class Observer {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        WeatherObserver observer = (temp) -> System.out.println("temperature: " + temp);
        station.addObserver(observer);
        station.setTemperature(25);
        station.removeObserver(observer);
        station.setTemperature(30);
    }
}
