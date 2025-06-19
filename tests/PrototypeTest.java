package tests;

interface Document extends Cloneable {
    Document clone();
    void setTitle(String title);
    void print();
}

class Report implements Document {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public Document clone() {
        return new Report(this.title, this.content);
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Report Title: " + title);
        System.out.println("Content: " + content);
    }
}


public class PrototypeTest {
    public static void main(String[] args) {
        Report original = new Report("Monthly Report", "Sales went up by 10%");
        original.print();

        System.out.println("\n--- Cloning report ---");

        Report copy = (Report) original.clone();
        copy.setTitle("Cloned Report");
        copy.print();
    }
}
