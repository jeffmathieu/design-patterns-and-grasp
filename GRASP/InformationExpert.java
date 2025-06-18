package GRASP;

import java.util.ArrayList;
import java.util.List;

class Invoice {

    List<Double> items;

    public Invoice(List<Double> items) {
        this.items = items;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Double::doubleValue).sum();
    }

}

public class InformationExpert {
    public static void main(String[] args){
        List<Double> inv = new ArrayList<>();
        inv.add(2.345);
        inv.add(12.458);
        inv.add(58.41);
        inv.add(0.012);

        Invoice invoice = new Invoice(inv);
        System.out.println(invoice.calculateTotal());
    }
}
