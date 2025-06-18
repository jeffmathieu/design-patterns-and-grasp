package seen;

interface TextView {
    void display();
}
class PlainTextView implements TextView {
    public void display() {
        System.out.println("Displaying text");
    }
}

class ScrollableView implements TextView {

    private final TextView view;

    ScrollableView(TextView view) { this.view = view; }

    public void display() {
        view.display();
        System.out.println("With scrollbars");
    }

}

public class DecoratorDemo{
    public static void main(String[] args) {
        TextView simpleView = new PlainTextView();
        System.out.println("=== Plain View ===");
        simpleView.display();

        TextView decoratedView = new ScrollableView(simpleView);
        System.out.println("\n=== Decorated View ===");
        decoratedView.display();
    }
}
