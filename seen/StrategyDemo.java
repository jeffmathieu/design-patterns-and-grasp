package seen;

import java.util.ArrayList;
import java.util.List;

interface SortStrategy {
    int compare(String a, String b);
}
class CaseSensitive implements SortStrategy {
    public int compare(String a, String b) { return a.compareTo(b); }
}
class CaseInsensitive implements SortStrategy {
    public int compare(String a, String b) { return a.compareToIgnoreCase(b); }
}

public class StrategyDemo{
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Alice", "bob", "Charlie", "adam"));

        // Use CaseSensitive strategy
        SortStrategy caseSensitive = new CaseSensitive();
        names.sort(caseSensitive::compare);
        System.out.println("Case-sensitive sort: " + names);

        // Use CaseInsensitive strategy
        SortStrategy caseInsensitive = new CaseInsensitive();
        names.sort(caseInsensitive::compare);
        System.out.println("Case-insensitive sort: " + names);
    }
}
