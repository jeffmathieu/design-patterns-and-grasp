package seen;

interface Command {
    void execute();
    void undo();
}
class Editor {
    StringBuilder text = new StringBuilder();
    void insert(String s) { text.append(s); }
    void deleteLast() { if (text.length() > 0) text.deleteCharAt(text.length() - 1); }
    public String getText() { return text.toString(); }
}
class InsertCommand implements Command {
    private final Editor editor;
    private final String s;
    InsertCommand(Editor editor, String s) { this.editor = editor; this.s = s; }
    public void execute() { editor.insert(s); }
    public void undo() { editor.deleteLast(); }
}
public class CommandDemo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Command cmd = new InsertCommand(editor, "A");
        cmd.execute();
        System.out.println("Text: " + editor.getText());
        cmd.undo();
        System.out.println("Text after undo: " + editor.getText());
    }
}
