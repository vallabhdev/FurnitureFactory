package designs.behavioral.chainofresponsibility;

public class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void displayLog(String msg) {
        System.out.println("Error logger info : " + msg);
    }
}
