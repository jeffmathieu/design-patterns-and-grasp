package tests;

interface Image {
    void display();
}

class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // lazy load
        }
        realImage.display();
    }
}


public class ProxyDemo {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("highres_photo.jpg");

        System.out.println("Before display");
        img1.display();  // loads and displays

        System.out.println("Second display");
        img1.display();  // just displays, no load
        }
}
