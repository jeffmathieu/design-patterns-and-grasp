package GRASP;

class Logger {
    public static void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

class Order1 {
    private final String item;

    public Order1(String item) {
        this.item = item;
    }

    public void process() {
        Logger.log("Processing order for: " + item);
    }
}

public class PureFabrication {
    public static void main(String[] args){
        Order1 order = new Order1("shoes");
        order.process();
    }

}
