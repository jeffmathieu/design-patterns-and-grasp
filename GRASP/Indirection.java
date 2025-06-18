package GRASP;

interface PaymentGateway {
    void pay(double amount);
}

class PaypalGateway implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid €" + amount + " via PayPal.");
    }
}

class CreditCardGateway implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid €" + amount + " via Credit Card.");
    }
}

class PaymentService {
    private final PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void makePayment(double amount) {
        gateway.pay(amount);
    }
}

public class Indirection {
    public static void main(String[] args) {
        PaymentGateway paypal = new PaypalGateway();
        PaymentGateway creditCard = new CreditCardGateway();

        PaymentService service1 = new PaymentService(paypal);
        service1.makePayment(49.99);

        PaymentService service2 = new PaymentService(creditCard);
        service2.makePayment(89.50);
    }
}
