package designs.behavioral.chainofresponsibility;

public class ChainOfResponsibilityClient {

    private static Logger doChaining() {
        Logger consoleLogger = new ConsoleLog(Logger.INFO);
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        consoleLogger.setNextLevelLogger(errorLogger);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        errorLogger.setNextLevelLogger(debugLogger);
        return consoleLogger;
    }

    public static void main(String[] args) {
        Logger chainLogger = doChaining();
//        chainLogger.logMessage(Logger.INFO, "Into INFO mode");
        System.out.println("next statement");
//        chainLogger.logMessage(Logger.ERROR, "Into ERROR mode");
        System.out.println("next statement");
        chainLogger.logMessage(Logger.DEBUG, "Into Debug mode");
    }

}
