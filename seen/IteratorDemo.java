package seen;

interface MyIterator {
    boolean hasNext();
    int next();
}
class MyList {
    private final java.util.List<Integer> items = java.util.List.of(1, 2, 3);
    public MyIterator iterator() {
        return new MyIterator() {
            private int index = 0;
            public boolean hasNext() { return index < items.size(); }
            public int next() { return items.get(index++); }
        };
    }
}
public class IteratorDemo {
    public static void main(String[] args) {
        MyList list = new MyList();
        MyIterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
