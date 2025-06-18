package seen;

abstract class Report {
    void printReport() {
        printHeader();
        printBody();
        printFooter();
    }
    abstract void printHeader();
    abstract void printBody();
    abstract void printFooter();
}
class SimpleReport extends Report {
    void printHeader() { System.out.println("=== Report ==="); }
    void printBody() { System.out.println("This is the body"); }
    void printFooter() { System.out.println("=== End ==="); }
}
class SimpleReport2 extends Report {
    void printHeader() { System.out.println("=== Report 2 ==="); }
    void printBody() { System.out.println("This is the second template"); }
    void printFooter() { System.out.println("=== End 2 ==="); }
}

public class TemplateDemo{
    public static void main(String[] args) {
        SimpleReport test = new SimpleReport();
        test.printReport();

        SimpleReport2 test2 = new SimpleReport2();
        test2.printReport();
    }
}
