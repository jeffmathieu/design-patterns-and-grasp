package tests;

interface LightState {
    void toggle(Light light);
}

class OffState implements LightState {
    public void toggle(Light light) {
        light.state = new OnState();
        System.out.println("turning on");
    }
}

class OnState implements LightState {
    public void toggle(Light light) {
        light.state = new OffState();
        System.out.println("turning off");
    }
}

class Light {
    LightState state = new OnState();
    void toggle() {state.toggle(this);}
}

public class StateTest {
    public static void main(String[] args) {
        Light light = new Light();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();
        light.toggle();

    }
}
