package GRASP;

class TemperatureConverter {
    public double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}

public class HighCohesion {
    public static void main(String[] args){
        TemperatureConverter converter = new TemperatureConverter();
        System.out.println(converter.celsiusToFahrenheit(31.1));
    }
}
