package quartz.engine;

public class Logger {

    private static Logger logger = null;

    public static Logger getLogger() {
        if (logger == null)
            logger = new Logger();

        return logger;
    }

    public void Debug(String message) {
        System.out.println(message);
    }

    public void Info(String message) {
        System.out.println(message);
    }

    public void Error(String message) {
        System.err.println(message);
    }
}
