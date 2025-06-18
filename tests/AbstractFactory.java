package tests;

interface VehicleFactory {
    Car createCar();
    Truck createTruck();
}

class SportsFactory implements VehicleFactory {
    public Car createCar() {return new Porsche();}
    public Truck createTruck() {return new Ford();}
}

class RaceFactory implements VehicleFactory {
    public Car createCar() {return new RacePorsche();}
    public Truck createTruck() {return new SafetyTruck();}
}

class Car {
    int horsePower;
    int weight;
    String model;
}

class Truck {
    int horsePower;
    int wheels;
    String model;
}

class Porsche extends Car {
    Porsche() {
        horsePower = 500;
        weight = 1200;
        model = "911";
    }
}

class Ford extends Truck {
    Ford() {
        horsePower = 400;
        wheels = 4;
        model = "F150";
    }
}

class RacePorsche extends Car {
    RacePorsche() {
        horsePower = 860;
        weight = 1300;
        model = "911 GT3RS";
    }
}

class SafetyTruck extends Truck {
    SafetyTruck() {
        horsePower = 600;
        wheels = 8;
        model = "marshall car";
    }
}



public class AbstractFactory {
    public static void main(String[] args) {
        RaceFactory fac = new RaceFactory();
        System.out.println(fac.createCar());
        System.out.println(fac.createTruck());

        SportsFactory fac1 = new SportsFactory();
        System.out.println(fac1.createCar());
        System.out.println(fac1.createTruck());
    }
}
