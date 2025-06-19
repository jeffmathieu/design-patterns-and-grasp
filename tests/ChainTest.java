package tests;

abstract class HelpHandler {
    protected HelpHandler next;

    public HelpHandler setNext(HelpHandler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(String request);
}

class Level1Support extends HelpHandler {
    public void handle(String request) {
        if (request.contains("password") || request.contains("login")) {
            System.out.println("Level 1 handled: " + request);
        } else if (next != null) {
            next.handle(request);
        }
    }
}

class Level2Support extends HelpHandler {
    public void handle(String request) {
        if (request.contains("network") || request.contains("email")) {
            System.out.println("Level 2 handled: " + request);
        } else if (next != null) {
            next.handle(request);
        }
    }
}

class Level3Support extends HelpHandler {
    public void handle(String request) {
        System.out.println("Level 3 handled (escalated): " + request);
    }
}


public class ChainTest {
    public static void main(String[] args) {
        HelpHandler level1 = new Level1Support();
        HelpHandler level2 = new Level2Support();
        HelpHandler level3 = new Level3Support();

        level1.setNext(level2).setNext(level3);  // chain setup

        level1.handle("forgot my password");
        level1.handle("email server is down");
        level1.handle("site is offline, losing money!");
    }
}
