package seen;

abstract class FileSystemEntry {
    String name;
    abstract int getSize();
}
class File extends FileSystemEntry {
    int size;
    File(String name, int size) { this.name = name; this.size = size; }
    int getSize() { return size; }
}
class Directory extends FileSystemEntry {
    java.util.List<FileSystemEntry> children = new java.util.ArrayList<>();
    void add(FileSystemEntry entry) { children.add(entry); }
    int getSize() {
        return children.stream().mapToInt(FileSystemEntry::getSize).sum();
    }
}
public class Composite {
    public static void main(String[] args) {
        Directory root = new Directory();
        root.add(new File("a.txt", 10));
        Directory sub = new Directory();
        sub.add(new File("b.txt", 20));
        root.add(sub);
        System.out.println("Total size: " + root.getSize());
    }
}
