package GRASP;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Draw Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Draw Square"); }
}

public class Polymorphism {
    public static void main(String[] args){
        Shape circle = new Circle();
        Shape square = new Square();
        circle.draw();
        square.draw();
    }
}
