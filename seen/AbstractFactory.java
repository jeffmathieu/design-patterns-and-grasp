package seen;

interface Button { void draw(); }
interface TextField { void draw(); }
interface GUIFactory {
    Button createButton();
    TextField createTextField();
}
class DarkThemeFactory implements GUIFactory {
    public Button createButton() { return () -> System.out.println("Dark Button"); }
    public TextField createTextField() { return () -> System.out.println("Dark TextField"); }
}
class LightThemeFactory implements GUIFactory {

    @Override
    public Button createButton() { return () -> System.out.println("Light Button"); }

    @Override
    public TextField createTextField() { return () -> System.out.println("Light TextField"); }
}
public class AbstractFactory {
    public static void main(String[] args) {
        GUIFactory factory = new DarkThemeFactory();
        factory.createButton().draw();
        factory.createTextField().draw();
        GUIFactory fact = new LightThemeFactory();
        fact.createButton().draw();
        fact.createTextField().draw();
    }
}
