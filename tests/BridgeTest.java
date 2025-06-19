package tests;

interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

class TV implements Device {
    public void turnOn() {
        System.out.println("TV on");
    }

    public void turnOff() {
        System.out.println("TV off");
    }

    public void setVolume(int level) {
        System.out.println("TV volume set to " + level);
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio on");
    }

    public void turnOff() {
        System.out.println("Radio off");
    }

    public void setVolume(int level) {
        System.out.println("Radio volume set to " + level);
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.turnOn();
    }

    public void powerOff() {
        device.turnOff();
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}


public class BridgeTest {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        RemoteControl remote1 = new AdvancedRemote(tv);
        RemoteControl remote2 = new AdvancedRemote(radio);

        remote1.powerOn();     // TV on
        ((AdvancedRemote) remote1).mute();  // TV volume set to 0

        remote2.powerOn();     // Radio on
        ((AdvancedRemote) remote2).mute();  // Radio volume set to 0

        remote1.powerOff();

        remote2.powerOff();
    }
}
