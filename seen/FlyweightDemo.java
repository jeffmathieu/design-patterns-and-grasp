package seen;

class Number {
    private final int value;
    private Number(int value) { this.value = value; }
    private static final java.util.Map<Integer, Number> cache = new java.util.HashMap<>();
    public static Number of(int value) {
        return cache.computeIfAbsent(value, Number::new);
    }
    public int getValue() { return value; }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        Number n1 = Number.of(5);
        Number n2 = Number.of(5);
        Number n3 = Number.of(10);

        System.out.println("n1 value: " + n1.getValue());
        System.out.println("n2 value: " + n2.getValue());
        System.out.println("n3 value: " + n3.getValue());

        System.out.println("n1 and n2 are the same object: " + (n1 == n2));
        System.out.println("n1 and n3 are the same object: " + (n1 == n3));
    }
}
