package GRASP;

class OrderController {
    public void createOrder(String itemName) {
        Order order = new Order();
        order.addItem(itemName);
        System.out.println("Order created.");
    }
}

public class Controller {
    public static void main(String[] args){
        OrderController controller = new OrderController();
        controller.createOrder("shoe");
    }
}
