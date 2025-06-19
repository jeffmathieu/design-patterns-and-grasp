package GRASP;
class Facade {
    final OrderService orderService = new OrderService();
    final PaymentService1 paymentService = new PaymentService1();

    void checkout(String cName) {
        orderService.createOrder(cName);
        paymentService.processPayment(cName);
        System.out.println("Checkout completed for " + cName + ".\n");
    }

}

class OrderService {
    void createOrder(String cName) {System.out.println("order for " + cName + " created.");}
}

class PaymentService1 {
    void processPayment(String cName) {System.out.println("payment processed for " + cName + ".");}
}

public class FacadeController {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.checkout("Jeff");
        facade.checkout("Lene");
    }

}
