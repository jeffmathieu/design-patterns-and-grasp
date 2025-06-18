package seen;

class Document {
    String title;
    java.util.List<String> paragraphs = new java.util.ArrayList<>();
}
class DocumentBuilder {
    private final Document doc = new Document();
    public DocumentBuilder setTitle(String title) {
        doc.title = title; return this;
    }
    public DocumentBuilder addParagraph(String p) {
        doc.paragraphs.add(p); return this;
    }
    public Document build() { return doc; }
    public void print() {
        System.out.println(doc.title);
        for (String p : doc.paragraphs) {
            System.out.println(p);
        }
    }
}

public class BuilderDemo{
    public static void main(String[] args) {
         DocumentBuilder builder = new DocumentBuilder();
         builder.setTitle("new Document!");
         builder.addParagraph("This is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.\nThis is a new document style.");
         builder.addParagraph("wow wow wow\nwow wow wow\nwow wow wow\nwow wow wow\nwow wow wow");
         builder.print();
    }
}
