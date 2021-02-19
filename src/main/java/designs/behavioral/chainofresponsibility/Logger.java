package designs.behavioral.chainofresponsibility;

public abstract class Logger {
    public static int INFO = 1;
    public static int ERROR = 2;
    public static int DEBUG = 3;
    int level;
    Logger nextLevelLogger;

    public void setNextLevelLogger(Logger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(int level, String msg) {
        if (this.level <= level) {
            displayLog(msg);
        }
        if (nextLevelLogger != null) {
            nextLevelLogger.logMessage(level, msg);
        }
    }

    protected abstract void displayLog(String msg);
}
