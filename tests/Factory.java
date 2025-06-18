package tests;

abstract class Factory {
    String model;
    int wheels;
    int horsePower;
    int weight;
    double length;
    abstract void print();

    public static void main(String[] args) {
        Factory car = new CarFactory();
        Factory truck = new TruckFactory();

        car.print();
        truck.print();
    }

}

class CarFactory extends Factory {

    CarFactory() {
        model = "Porsche 911 GT3";
        wheels = 4;
        horsePower = 669;
        weight = 1200;
        length = 2.5;
    }

    void print() {
        System.out.println("     -----    -");
        System.out.println("   --     -  - ");
        System.out.println(" ------------- ");
        System.out.println("   ---    ---  ");
    }
}

class TruckFactory extends Factory {

    TruckFactory() {
        model = "Ford F150";
        wheels = 6;
        horsePower = 512;
        weight = 3600;
        length = 5.32;
    }

    void print() {
        System.out.println(" -----             ");
        System.out.println(" -   ------------- ");
        System.out.println(" ----------------- ");
        System.out.println("   ---    ---  --- ");
    }
}


