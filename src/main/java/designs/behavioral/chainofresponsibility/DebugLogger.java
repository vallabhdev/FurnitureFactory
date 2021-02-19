package designs.behavioral.chainofresponsibility;

public class DebugLogger extends Logger {
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void displayLog(String msg) {
        System.out.println("Debug logger info : " + msg);
    }
}
