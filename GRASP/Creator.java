package GRASP;

import java.util.ArrayList;
import java.util.List;

class Order {
    List<Item> items = new ArrayList<>();

    public Item addItem(String name) {
        Item item = new Item(name);
        items.add(item);
        return item;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Item {
    String name;
    public Item(String name) { this.name = name; }
}

class Creator {
    public static void main(String[] args){
        Order order = new Order();
        order.addItem("shirt");
        order.addItem("pants");
        order.addItem("shoes");
        order.addItem("sweater");

        System.out.println(order.getItems());
    }
}

