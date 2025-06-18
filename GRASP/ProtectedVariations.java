package GRASP;

interface Storage {
    void save(String data);
}

class FileStorage implements Storage {
    public void save(String data) { System.out.println("Saved to file to disk"); }
}

class CloudStorage implements Storage {
    public void save(String data) { System.out.println("Saved to file to cloud"); }
}

public class ProtectedVariations {
    public static void main(String[] args) {
        Storage storage = new FileStorage();
        storage.save("Hello to disk");

        Storage storage1 = new CloudStorage();
        storage1.save("Hello to cloud");
    }
}
