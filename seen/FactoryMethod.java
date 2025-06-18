package seen;

abstract class Document1 {
    abstract void print();
}
class TextDocument extends Document1 {
    void print() { System.out.println("Text document"); }
}
abstract class Application {
    Document1 currentDocument;
    abstract Document1 createDocument();
    void newDocument() {
        currentDocument = createDocument();
        currentDocument.print();
    }
}
class TextEditor extends Application {
    Document1 createDocument() { return new TextDocument(); }
}
public class FactoryMethod {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.newDocument();
    }
}
