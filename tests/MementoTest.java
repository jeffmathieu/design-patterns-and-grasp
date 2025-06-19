package tests;

import java.util.Stack;

class TextMemento {
    private final String text;

    public TextMemento(String text) {
        this.text = text;
    }

    public String getSavedText() {
        return text;
    }
}

class TextEditor {
    private String text = "";

    public void write(String newText) {
        text += newText;
    }

    public String getText() {
        return text;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        text = memento.getSavedText();
    }
}

class History {
    private final Stack<TextMemento> states = new Stack<>();

    public void save(TextEditor editor) {
        states.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!states.isEmpty()) {
            editor.restore(states.pop());
        }
    }
}



public class MementoTest {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello");
        history.save(editor);

        editor.write(" World!");
        System.out.println("Current: " + editor.getText()); // Hello World!

        history.undo(editor);
        System.out.println("After undo: " + editor.getText()); // Hello
    }
}
