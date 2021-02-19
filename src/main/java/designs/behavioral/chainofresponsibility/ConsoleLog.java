package designs.behavioral.chainofresponsibility;

public class ConsoleLog extends Logger {
    public ConsoleLog(int level) {
        this.level = level;
    }

    @Override
    protected void displayLog(String msg) {
        System.out.println("Console logger info : " + msg);
    }
}
