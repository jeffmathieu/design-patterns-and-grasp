package seen;

interface LightState {
    void toggle(Light light);
}
class Light {
    LightState state = new OffState();
    void toggle() { state.toggle(this); }
}
class OnState implements LightState {
    public void toggle(Light light) {
        System.out.println("Turning off");
        light.state = new OffState();
    }
}
class OffState implements LightState {
    public void toggle(Light light) {
        System.out.println("Turning on");
        light.state = new OnState();
    }
}

public class StateDemo{
    public static void main(String[] args) {
        Light light = new Light();
        System.out.println(light.state);
        light.toggle();
        System.out.println(light.state);
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
    }
}