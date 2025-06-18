package GRASP;

class Report {
    public String generate() {
        return "Report content";
    }
}

class Printer {
    public void print(String text) {
        System.out.println(text);
    }
}

public class LowCoupling {
    public static void main(String[] args){
        Report report = new Report();
        Printer printer = new Printer();
        printer.print(report.generate());
    }
}
