package seen;

interface ShapeVisitor {
    void visitCircle(Circle c);
    void visitRectangle(Rectangle r);
}
interface Shape {
    void accept(ShapeVisitor v);
}
class Circle implements Shape {
    public void accept(ShapeVisitor v) { v.visitCircle(this); }
}
class Rectangle implements Shape {
    public void accept(ShapeVisitor v) { v.visitRectangle(this); }
}
class DrawingVisitor implements ShapeVisitor {
    public void visitCircle(Circle c) { System.out.println("Draw Circle"); }
    public void visitRectangle(Rectangle r) { System.out.println("Draw Rectangle"); }
}

public class VisitorDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        ShapeVisitor visitor = new DrawingVisitor();

        circle.accept(visitor);
        rectangle.accept(visitor);
    }
}
